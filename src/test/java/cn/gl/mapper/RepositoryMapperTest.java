package cn.gl.mapper;

import cn.gl.pojo.Repository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class RepositoryMapperTest {
    @Autowired
    RepositoryMapper repositoryMapper;

    @Test
    public void test1(){
        Repository repository = repositoryMapper.selectRepoByURL("https://github.com/williamngan/pts");
        System.out.println(repository);
    }

    /**
     * 测试方法 List<Repository> selectRepoByFirstDate(Date date);
     */
    @Test
    public void test2() throws ParseException {
        String strDate = "2018-08-10";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(strDate);
        List<Repository> repositories = repositoryMapper.selectRepoByFirstDate(date);
        for (Repository repository : repositories) {
            System.out.println(repository);
        }
    }

    /**
     * 测试方法 Integer deleteRepoByFirstDate(Repository repo);
     */
    @Test
    public void test3() throws ParseException {
        String strDate = "2018-08-10";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(strDate);
        List<Repository> repositories = repositoryMapper.selectRepoByFirstDate(date);
        for (Repository repository : repositories) {
            System.out.println(repository);
        }

        Repository repository = repositories.get(0);
        System.out.println(repository);
        Integer integer = repositoryMapper.deleteRepoById(repository);
        System.out.println(integer);
    }
}
