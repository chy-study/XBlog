package springboot.xblogserver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CHY
 * @date 2020/4/2 20:06
 * @description 用户角色表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    private Integer id;
    private String name;
}
