package springboot.xblogserver.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CHY
 * @date 2020/3/19 22:53
 */
@RestController
public class test {
    @RequestMapping("/hello")
    private String hello(){
        return "hello world";
    }
}
