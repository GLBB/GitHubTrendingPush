package cn.gl.springMybatis;

import cn.gl.mapper.RepositoryMapper;
import cn.gl.pojo.Repository;
import cn.gl.url.GetRepo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Checkout {

    ApplicationContext applicationContext = null;

    @Before
    public void init(){
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }
    /**
     * initial 测试运行
     */
    @Test
    public void test1(){
        List<Repository> repos = GetRepo.getRepos("https://github.com/trending");
        RepositoryMapper mapper = applicationContext.getBean(RepositoryMapper.class);
        System.out.println(repos.get(1));
        System.out.println();
        mapper.saveRepo(repos.get(1));
    }
}
