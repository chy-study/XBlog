package springboot.xblogserver.dao;

import org.apache.ibatis.annotations.Param;
import springboot.xblogserver.domain.Blog;

import java.util.List;

/**
 * @author CHY
 * @date 2020/4/4 22:44
 * @description 博客dao接口
 */
public interface IBlogDao {
    int getBlogsCountByConditions(@Param("userId") Integer userId,
                                  @Param("statu") Integer statu,
                                  @Param("keyword") String keyword);

    List<Blog> getBlogsByConditions(@Param("userId") Integer userId,
                                     @Param("statu") Integer statu,
                                     @Param("count") Integer count,
                                     @Param("index") Integer index,
                                     @Param("keyword") String keyword);
    }
