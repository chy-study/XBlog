package springboot.xblogserver.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springboot.xblogserver.domain.User;
import springboot.xblogserver.service.IUserService;

/**
 * @author CHY
 * @date 2020/3/23 21:38
 */
@SpringBootTest
class UserControllerTest {

    @Autowired
    private IUserService iUserService;

    @Test
    void findUser(){
        User user = new User();
        user.setUsername("test");
        user.setPassword("123456");
        User u = iUserService.selectOne(user);
        System.out.println(u);
    }
}