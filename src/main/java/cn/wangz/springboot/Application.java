package cn.wangz.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by hadoop on 2018/9/6.
 */

/**
 * We generally recommend that you locate your main application class in a root package above other classes. The @SpringBootApplication annotation is often placed on your main class, and it implicitly defines a base “search package” for certain items.
 * 我们通常建议您将主应用程序类放在其他类之上的根包中。 @SpringBootApplication注释通常放在您的主类上，它隐式地为某些项定义了一个基础“搜索包”。
 *
 * 此外@SpringBootApplication注解可以用@Configuration @EnableAutoConfiguration @ComponentScan代替
 *
 * SpringBootApplication exclude 可以配置排除的类，可以排除一些自动配置的类
 */
@SpringBootApplication
@ComponentScan
@EnableScheduling
@EnableAsync
@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            //CommandLineRunner 中可以做一些初始化的工作
        };
    }
}
