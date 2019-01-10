package cn.wangz.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by hadoop on 2019/1/10.
 */
@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(String msg) {
        kafkaTemplate.send("topic", msg);
    }
}
