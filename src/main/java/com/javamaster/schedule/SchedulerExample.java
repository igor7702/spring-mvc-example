package com.javamaster.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SchedulerExample {
    //fixedRate in milliseconds
    //@Scheduled(fixedRate = 3000)

    //cron in milliseconds
    //@Scheduled(cron = "*/3 * * * * *") // Формат:  секунда, минута, час, день, месяц, день недели

    public void reportCurrentData() {
        System.out.println("Scheduler working: " + new Date());
    }
}
