package com.dec2023.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@Configuration
public class SchedulerSample {

//    @Scheduled(fixedDelay = 5000)
//    public void printMessage(){
//    System.out.println(LocalDateTime.now());
//    }
    @Scheduled(cron ="* 43 14 * * *")
    public void printMessage(){
        System.out.println("inside scheduler "+LocalDateTime.now());
    }
}
