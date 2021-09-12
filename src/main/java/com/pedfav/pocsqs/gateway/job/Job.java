package com.pedfav.pocsqs.gateway.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Job {

    @Scheduled(cron="${job.cron}")
    public void checkPayments() {
        log.info("Checking payments");
    }
}
