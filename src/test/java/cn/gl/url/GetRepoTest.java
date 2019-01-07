package cn.gl.url;

import cn.gl.pojo.Repository;
import org.junit.Test;

import java.util.List;

public class GetRepoTest {

    /**
     * 测试方法 cn.gl.url.GetRepo#getRepo(java.lang.String)
     */
    @Test
    public void test(){
        List<Repository> repoList = GetRepo.getRepos("https://github.com/trending");
        System.out.println(repoList.size());
        for (Repository repo : repoList) {
            System.out.println(repo);
        }
    }
}
