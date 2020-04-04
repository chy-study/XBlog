package springboot.xblogserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springboot.xblogserver.service.IUserService;

/**
 * @author CHY
 * @date 2020/3/23 21:38
 */
@SpringBootTest
class UserControllerTest {

    @Autowired
    private IUserService iUserService;


}