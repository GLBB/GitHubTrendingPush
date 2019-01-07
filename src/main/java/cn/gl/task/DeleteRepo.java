package cn.gl.task;

import cn.gl.service.RepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

@Component
public class DeleteRepo implements Runnable {
    @Autowired
    RepositoryService repositoryService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run() {
        logger.info("开始删除三天前的英文仓库");
        repositoryService.deleteRepoEnglish();
        logger.info("仓库删除结束");
    }
}
