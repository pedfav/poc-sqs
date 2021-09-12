package com.pedfav.pocsqs.gateway.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Job {

    @Scheduled(cron="0 0/1 * * * ?")
    public void checkPayments() {
        System.out.println("Checking payments" + System.currentTimeMillis() / 1000);
    }
}
