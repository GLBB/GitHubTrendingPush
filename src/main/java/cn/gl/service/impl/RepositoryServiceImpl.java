package cn.gl.service.impl;

import cn.gl.mapper.RepositoryMapper;
import cn.gl.pojo.Repository;
import cn.gl.service.RepositoryService;
import cn.gl.util.DateUtil;
import cn.gl.util.LanguageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RepositoryServiceImpl implements RepositoryService {
    @Autowired
    RepositoryMapper repositoryMapper;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 根据得到的 repos 列表， 从数据库中判断是否有重复的
     * @param repos 得到的 repos 列表
     */
    public void saveList(List<Repository> repos){
        logger.info("保存仓库过程中");
        var newRepos = new ArrayList<Repository>();
        var updateRepos = new ArrayList<Repository>();

        for (Repository repo : repos) {
            Repository repository = null;
            try{
                repository = repositoryMapper.selectRepoByURL(repo.getURL());
            }catch (Exception e){
                logger.error("根据 url 查询数据库出现异常了");
                logger.error(e.toString());
            }

            if (repository == null) {
                repo.setSend(false);
                repo.setFirstDate(new Date());
                newRepos.add(repo);
            }else {
                repo.setTodayStar(repository.getTodayStar());
                updateRepos.add(repo);
            }
        }
        logger.info("新仓库有 {} 个.", newRepos.size());
        logger.info("要更新的仓库有 {} 个", updateRepos.size());

        for (Repository newRepo : newRepos) {
            repositoryMapper.saveRepo(newRepo);
        }
        logger.info("新仓库保存完成");

        for (Repository updateRepo : updateRepos) {
            repositoryMapper.updateRepo(updateRepo);
        }
        logger.info("更新仓库完成");
    }

    /**
     * 删除 3 天以前的英文仓库
     */
    @Override
    public void deleteRepoEnglish() {
        var deleteList = new ArrayList<Repository>();
        Date threeDay = DateUtil.threeDayBefore();
        logger.info("查找三天前的仓库");
        List<Repository> repositories = repositoryMapper.selectRepoByFirstDate(threeDay);
        logger.info("三天前的仓库有 {} 个", repositories.size());
        // 判断 repo 是否是中文仓库
        logger.info("排除中文仓库");
        for (Repository repository : repositories) {
            boolean chinese = LanguageUtil.isChinese(repository.getIntro());
            if (!chinese) {
                deleteList.add(repository);
            }
        }
        logger.info("要删除的仓库有 {} 个", deleteList.size());

        logger.info("删除开始");
        for (Repository repository : deleteList) {
            repositoryMapper.deleteRepoById(repository);
        }
        logger.info("删除结束");
    }


}
