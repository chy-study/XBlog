package springboot.xblogserver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @author CHY
 * @date 2020/4/4 22:12
 * @description 博客实体类
 *   `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
 *   `uid` int(6) unsigned NOT NULL COMMENT '用户id',
 *   `title` varchar(255) DEFAULT NULL COMMENT '标题',
 *   `mdContent` text COMMENT 'md文件源码',
 *   `htmlContent` text COMMENT 'html源码',
 *   `statu` int(11) DEFAULT NULL COMMENT '0全部，1已发表，2草稿箱，3回收站',
 *   `InsertTime` datetime DEFAULT NULL COMMENT '写入时间',
 *   `UpdateTime` datetime DEFAULT NULL COMMENT '更新时间',
 *   `pageView` int(11) DEFAULT '0' COMMENT '访问量',
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    private Integer id;
    private Integer uid;
    private String title;
    private String mdContent;
    private String htmlContent;
    private Integer statu;
    private Timestamp InsertTime;
    private Timestamp UpdateTime;
    private Integer pageView;
}
