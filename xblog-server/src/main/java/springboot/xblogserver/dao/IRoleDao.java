package springboot.xblogserver.dao;

import springboot.xblogserver.domain.Role;

import java.util.List;

/**
 * @author CHY
 * @date 2020/4/2 20:35
 * @description 角色dao接口
 */
public interface IRoleDao {
    List<Role> getRolesByUid(Integer id);
}
