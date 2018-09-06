package cn.wangz.springboot.conf;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by hadoop on 2018/9/6.
 */
@Component
@ToString(exclude = "INSTANCE")
@Slf4j
public class MgoConf1 {

    @Value("${mongo.cluster}")
    private String cluster;
    @Value("${mongo.db}")
    private String db;
    @Value("${mongo.col}")
    private String col;

    public static MgoConf1 INSTANCE;

    @PostConstruct
    private void init() {
        INSTANCE = this;
//        log.info(INSTANCE.toString());
    }
}
