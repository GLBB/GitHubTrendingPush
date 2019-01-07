package cn.gl.task;

import cn.gl.pojo.Repository;
import cn.gl.service.RepositoryService;
import cn.gl.url.GetRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.SocketUtils;

import java.io.*;
import java.util.Date;
import java.util.List;

@Component
public class GrabRepo implements Runnable {
    @Autowired
    RepositoryService repositoryService;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run() {
        logger.info("开始抓取任务");
        logger.info("从 https://github.com/trending 抓取仓库");
        List<Repository> repos = GetRepo.getRepos("https://github.com/trending");
        logger.info("结束抓取仓库, 抓取到仓库 {} 个", repos.size());

        logger.info("开始保存仓库");
        repositoryService.saveList(repos);
        logger.info("仓库已存入数据库");
    }
}
