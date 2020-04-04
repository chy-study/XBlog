package springboot.xblogserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springboot.xblogserver.Utils.UserInSecurity;
import springboot.xblogserver.domain.Blog;
import springboot.xblogserver.service.IBlogService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author CHY
 * @date 2020/3/31 21:01
 * @description 博客的Controller
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private UserInSecurity userInSecurity;

    @Autowired
    private IBlogService blogService;

    @GetMapping("/")
    public Map<String,Object> getBlogsByConditions(@RequestParam(value = "statu",defaultValue = "0")Integer statu,
                                                   @RequestParam(value = "page",defaultValue = "1")Integer page,
                                                   @RequestParam(value = "count",defaultValue = "5")Integer count,
                                                   @RequestParam(value = "keyword",defaultValue = "")String Keyword)
    {
        Map<String,Object> map = new HashMap<>();

        //从Spring Security中获取用户信息
        Integer userId = userInSecurity.getUserFromSecurity().getId();
        if (userId == null){
            map.put("msg","获取信息失败");
            return map;
        }
        //获取符合条件的总记录数
        int totalCount = blogService.getBlogsCountByConditions(userId,statu,Keyword);
        //获取符合条件的单页数据
        List<Blog> blogs = blogService.getBlogsByConditions(userId,statu,page,count,Keyword);
        map.put("totalCount",totalCount);
        map.put("blogs",blogs);
        return map;
    }
}
