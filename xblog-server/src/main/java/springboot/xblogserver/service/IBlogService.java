package springboot.xblogserver.service;

import springboot.xblogserver.domain.Blog;

import java.util.List;

/**
 * @author CHY
 * @date 2020/4/4 22:32
 * @description 博客Service接口类
 */
public interface IBlogService {
    /**
     * 根据条件，获取博客的总记录数
     * @param userId
     * @param statu
     * @param keyword
     * @return
     */
    int getBlogsCountByConditions(Integer userId, Integer statu, String keyword);

    /**
     * 根据条件，获取对应的博客集合
     * @param userId
     * @param statu
     * @param page
     * @param count
     * @param keyword
     * @return
     */
    List<Blog> getBlogsByConditions(Integer userId, Integer statu, Integer page, Integer count, String keyword);
}
