package cn.wangz.springboot.conf;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.hadoop.hbase.HbaseTemplate;

/**
 * Created by hadoop on 2018/11/28.
 */
@Configuration
@EnableConfigurationProperties(HBaseProperties.class)
public class HBaseConf {

    private HBaseProperties properties;

    public HBaseConf(HBaseProperties properties){
        this.properties = properties;
    }

    @Bean
    public HbaseTemplate hbaseTemplate() {
        HbaseTemplate hbaseTemplate = new HbaseTemplate();
        org.apache.hadoop.conf.Configuration configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.quorum", properties.getQuorum());
        configuration.set("hbase.zookeeper.property.clientPort", properties.getClientPort());
        hbaseTemplate.setConfiguration(configuration);
        hbaseTemplate.setAutoFlush(true);
        return hbaseTemplate;
    }
}
