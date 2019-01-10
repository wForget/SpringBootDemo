package cn.wangz.springboot.service;

import cn.wangz.springboot.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 * Created by hadoop on 2019/1/10.
 */
@Service
public class MongoService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public User queryUser() {
        Criteria criteria = Criteria.where("is").is("1");
        Query query = new Query(criteria);
        return mongoTemplate.findOne(query, User.class);
    }
}
