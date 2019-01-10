package cn.wangz.springboot.controller;

import cn.wangz.springboot.bean.User;
import cn.wangz.springboot.bean.UserFilter;
import cn.wangz.springboot.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hadoop on 2018/9/6.
 */
@RestController
public class HelloWorldController {

    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/getUser")
    public List<User> getUser() {
        List<User> users = new ArrayList<>();
        User user1 = new User(1, "w1", 20, 1);

        asyncService.printUser(user1);

        users.add(user1);
        User user2 = new User(2, "w2", 20, 2);
        users.add(user2);

        return users;
    }

    @RequestMapping("/getUserByName")
    public List<User> getUserByName(@RequestParam String name) {
        List<User> users = new ArrayList<>();
        User user1 = new User(1, "w1", 20, 1);
        users.add(user1);
        User user2 = new User(2, "w2", 20, 2);
        users.add(user2);
        User user3 = new User(3, "w3", 30, 1);
        users.add(user3);
        User user4 = new User(4, "w4", 30, 2);
        users.add(user4);

        return users.stream().filter(user -> user.getName().equals(name)).collect(Collectors.toList());
    }

    //支持post json格式的参数
    @RequestMapping("/getUserByFilter")
    public List<User> getUserByFilter(@RequestBody(required = false) UserFilter filter) {
        List<User> users = new ArrayList<>();
        User user1 = new User(1, "w1", 20, 1);
        users.add(user1);
        User user2 = new User(2, "w2", 20, 2);
        users.add(user2);
        User user3 = new User(3, "w3", 30, 1);
        users.add(user3);
        User user4 = new User(4, "w4", 30, 2);
        users.add(user4);

        return users.stream().filter(user -> {
            if (filter == null) return true;

            boolean flag = true;
            if (filter.getId() != null) {
                flag = flag && filter.getId().equals(user.getId());
            }
            if (filter.getName() != null) {
                flag = flag && filter.getName().equals(user.getName());
            }
            if (filter.getAge() != null) {
                flag = flag && filter.getAge().equals(user.getAge());
            }
            if (filter.getGender() != null) {
                flag = flag && filter.getGender().equals(user.getGender());
            }
            return flag;
        }).collect(Collectors.toList());
    }
}
