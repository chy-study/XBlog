package springboot.xblogserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springboot.xblogserver.dao.IRoleDao;
import springboot.xblogserver.dao.IUserDao;
import springboot.xblogserver.domain.Role;
import springboot.xblogserver.domain.User;
import springboot.xblogserver.service.IUserService;

import java.util.List;

/**
 * @author CHY
 * @date 2020/3/23 21:36
 * 用户Service实现类
 */
@Service
public class UserServiceImpl implements IUserService, UserDetailsService {

    @Autowired
    private IUserDao userDao;
    @Autowired
    private IRoleDao roleDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.loadUserByUsername(s);
        if (user == null)
            return new User();

        //查询用户的角色信息，存入user中
        List<Role> roles = roleDao.getRolesByUid(user.getId());
        user.setRoles(roles);
        return user;
    }
}
