package cn.wangz.springboot.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by hadoop on 2018/9/6.
 */
@Getter
@Setter
@ToString
public class UserFilter {
    private Integer id;
    private String name;
    private Integer age;
    private Integer gender;
}
