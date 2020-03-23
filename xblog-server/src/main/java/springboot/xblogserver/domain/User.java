package springboot.xblogserver.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author CHY
 * @date 2020/3/23 20:45
 * 用户实体类
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer gender;
    private Integer role;
    private String email;
    @TableField(value = "regTime")
    private Timestamp regTime;
    @TableField(value = "updTime")
    private Timestamp updTime;
    private Integer enabled;
}
