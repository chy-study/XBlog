package springboot.xblogserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author CHY
 */
// Spring Boot 应用的标识
@SpringBootApplication
// mapper 接口类扫描包配置
@MapperScan("springboot.xblogserver.dao")
public class XblogServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(XblogServerApplication.class, args);
    }

}
