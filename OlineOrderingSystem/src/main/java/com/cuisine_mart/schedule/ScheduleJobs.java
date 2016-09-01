package com.cuisine_mart.schedule;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * Created by Rajiv on 9/1/2016.
 */
@Component
@EnableScheduling
public class ScheduleJobs {
//    @Scheduled(cron="0/5 * * * * *")
    public void prepareReport(){
        System.out.println("message");
    }
}
