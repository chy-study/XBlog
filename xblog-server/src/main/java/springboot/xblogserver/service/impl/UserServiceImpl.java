package springboot.xblogserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.xblogserver.dao.UserDao;
import springboot.xblogserver.domain.User;
import springboot.xblogserver.service.IUserService;

/**
 * @author CHY
 * @date 2020/3/23 21:36
 * 用户Service实现类
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User selectOne(User user){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",user.getUsername());
        wrapper.eq("password",user.getPassword());
        return userDao.selectOne(wrapper);
    }

}
