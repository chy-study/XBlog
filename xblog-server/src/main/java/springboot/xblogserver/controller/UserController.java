package springboot.xblogserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.xblogserver.domain.RespBean;
import springboot.xblogserver.service.IUserService;

/**
 * @author CHY
 * @date 2020/3/23 21:34
 * @description 用户的Controller
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 输入的用户名不存在时，会跳到这个方法
     * @return
     */
    @RequestMapping("/login_page")
    public RespBean login_page(){
        return new RespBean("error","登录失败");
    }
}
