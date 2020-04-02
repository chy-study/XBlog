package springboot.xblogserver.dao;

import org.apache.ibatis.annotations.Param;
import springboot.xblogserver.domain.User;

/**
 * @author CHY
 * @date 2020/3/23 21:32
 * 用户Dao接口类
 */
public interface IUserDao {
    User loadUserByUsername(@Param("username") String username);
}
