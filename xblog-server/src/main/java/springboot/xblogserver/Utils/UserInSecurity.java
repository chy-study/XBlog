package springboot.xblogserver.Utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import springboot.xblogserver.domain.User;

/**
 * @author CHY
 * @date 2020/4/4 22:24
 * @description 获取spring security保存的用户信息
 */
@Component
public class UserInSecurity {

    public User getUserFromSecurity(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }
}
