package springboot.xblogserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.xblogserver.dao.IBlogDao;
import springboot.xblogserver.domain.Blog;
import springboot.xblogserver.service.IBlogService;

import java.util.List;

/**
 * @author CHY
 * @date 2020/4/4 22:33
 * @description 博客Service实现类
 */
@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    private IBlogDao blogDao;

    @Override
    public int getBlogsCountByConditions(Integer userId, Integer statu, String keyword) {
        if (keyword == "" || "".equals(keyword)){
            keyword = null;
        }
        return blogDao.getBlogsCountByConditions(userId,statu,keyword);
    }

    @Override
    public List<Blog> getBlogsByConditions(Integer userId, Integer statu, Integer page, Integer count, String keyword) {
        if (keyword == "" || "".equals(keyword)){
            keyword = null;
        }
        //从第几条数据后取值
        int index = (page-1)*count;
        return blogDao.getBlogsByConditions(userId,statu,count,index,keyword);
    }
}
