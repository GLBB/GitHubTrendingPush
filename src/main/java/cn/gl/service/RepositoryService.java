package cn.gl.service;

import cn.gl.pojo.Repository;

import java.util.List;

public interface RepositoryService {
    /**
     *
     * @param repos
     */
    void saveList(List<Repository> repos);

    /**
     * 删除 3 天前的英文repo
     */
    void deleteRepoEnglish();

}
