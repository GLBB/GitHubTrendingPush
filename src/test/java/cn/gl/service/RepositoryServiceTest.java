package cn.gl.service;

import cn.gl.mapper.RepositoryMapper;
import cn.gl.pojo.Repository;
import cn.gl.service.impl.RepositoryServiceImpl;
import cn.gl.url.GetRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class RepositoryServiceTest {
    @Autowired
    RepositoryService repositoryService;
    /**
     * 测试 RepositoryService init初始化
     */
    @Test
    public void test1(){
        List<Repository> repos = GetRepo.getRepos("https://github.com/trending");
        repositoryService.saveList(repos);
    }

    @Test
    public void test2(){
        repositoryService.deleteRepoEnglish();
    }
}
