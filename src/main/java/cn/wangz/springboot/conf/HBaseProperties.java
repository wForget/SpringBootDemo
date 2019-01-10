package cn.wangz.springboot.conf;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by hadoop on 2018/11/28.
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "hbase")
public class HBaseProperties {
    private String quorum;
    private String clientPort;

    private String table;
}
