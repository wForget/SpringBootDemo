package cn.wangz.springboot.conf;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by hadoop on 2018/9/6.
 */
@Component
@ConfigurationProperties(prefix = "mongo")
@ToString(exclude = "INSTANCE")
@Slf4j
public class MgoConf2 {

    private String cluster;

    private String db;

    private String col;

    public static MgoConf2 INSTANCE;

    @PostConstruct
    private void init() {
        INSTANCE = this;
//        log.info(INSTANCE.toString());
    }

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }
}
