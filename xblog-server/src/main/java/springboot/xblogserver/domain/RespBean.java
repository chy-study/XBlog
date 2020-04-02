package springboot.xblogserver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CHY
 * @date 2020/4/2 20:14
 * @description 自定义返回
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {
    private String status;
    private String msg;
}
