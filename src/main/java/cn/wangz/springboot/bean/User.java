package cn.wangz.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by hadoop on 2018/9/6.
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private Integer gender;
}
