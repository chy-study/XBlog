package springboot.xblogserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.xblogserver.domain.User;
import springboot.xblogserver.service.IUserService;

/**
 * @author CHY
 * @date 2020/3/23 21:34
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @PostMapping("/login")
    public User login(@RequestBody User user){
        User u = iUserService.selectOne(user);
        if (u != null) {
            return u;
        }
        return new User();
    }
}
