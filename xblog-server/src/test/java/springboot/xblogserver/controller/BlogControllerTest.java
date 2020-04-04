package springboot.xblogserver.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springboot.xblogserver.service.IBlogService;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author CHY
 * @date 2020/4/4 23:02
 * @description a java file
 */
@SpringBootTest
class BlogControllerTest {
    @Autowired
    private IBlogService blogService;

    @Test
    public void getCountByConditions(){
        blogService.getBlogsCountByConditions(1,0,"博客");
    }

    @Test
    public void getByConditions(){
        blogService.getBlogsByConditions(1,0,1,5,"");
    }
}