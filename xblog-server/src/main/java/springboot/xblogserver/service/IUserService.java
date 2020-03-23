package springboot.xblogserver.service;

import springboot.xblogserver.domain.User;

/**
 * @author CHY
 * @date 2020/3/23 21:36
 * 用户Service接口类
 */
public interface IUserService {

    User selectOne(User user);
}
