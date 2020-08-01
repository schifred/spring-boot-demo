package com.example.demo.quartz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@EnableScheduling
@Component
@Slf4j
public class TestQuartz {
    @Scheduled(cron = "0 0/1 * * * ?")
    public void timerToNow(){
        log.info("now time:{} by quartz", LocalDateTime.now());
    }
}
