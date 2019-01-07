package cn.gl.mapper;

import cn.gl.pojo.Repository;

import java.util.Date;
import java.util.List;

public interface RepositoryMapper {
    Integer saveRepo(Repository repository);

    Repository selectRepoByURL(String URL);

    Integer updateRepo(Repository repo);

    /**
     * 删除一个 repo
     * @param repo
     * @return
     */
    Integer deleteRepoById(Repository repo);

    /**
     * 查询 指定日期之前的 repo
     */
    List<Repository> selectRepoByFirstDate(Date date);
}
