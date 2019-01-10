package cn.wangz.springboot.service;

import cn.wangz.springboot.bean.User;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by hadoop on 2019/1/10.
 *
 * 需要加上 @EnableAsync 注解
 *
 */
@Service
public class AsyncService {

    @Async
    public void printUser(User user) {
        System.out.println("async start....");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("user:" + user.toString());
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("async end....");
    }

}
