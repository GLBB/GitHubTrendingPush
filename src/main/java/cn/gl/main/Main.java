package cn.gl.main;

import cn.gl.task.DeleteRepo;
import cn.gl.task.GrabRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    static ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

    static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("任务开始");
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        GrabRepo grabRepo = applicationContext.getBean(GrabRepo.class);
        scheduledExecutorService.scheduleAtFixedRate(grabRepo, 0, 1, TimeUnit.DAYS);
        DeleteRepo deleteRepo = applicationContext.getBean(DeleteRepo.class);
        scheduledExecutorService.scheduleAtFixedRate(deleteRepo, 0, 3, TimeUnit.DAYS);
    }
}
