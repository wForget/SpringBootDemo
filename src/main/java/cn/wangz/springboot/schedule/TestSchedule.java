package cn.wangz.springboot.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by hadoop on 2019/1/8.
 *
 * 需要加上 @EnableScheduling 注解
 *
 */
@Component
@Slf4j
public class TestSchedule {

    @Scheduled(fixedRate = 5000L)    // 5s 更新一次
    public void schedule() {
        log.info("scheduled......");
    }
}
