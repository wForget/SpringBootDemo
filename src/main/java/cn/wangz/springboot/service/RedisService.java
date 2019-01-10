package cn.wangz.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by hadoop on 2019/1/10.
 */
@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

}
