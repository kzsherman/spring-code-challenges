package com.cecilireid.springchallenges;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduledTasks {

    final CateringJobRepository cateringJobRepository;

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    public ScheduledTasks(CateringJobRepository cateringJobRepository) {
        this.cateringJobRepository = cateringJobRepository;
    }

    @Scheduled (cron = "*/10 * * * * * ") //running method every 10 sec through spring scheduler
    public void reportOrderStats() {
        List<CateringJob> jobList = cateringJobRepository.findByStatus(Status.IN_PROGRESS);
        logger.info("We have {} jobs in progress", jobList.size());
        
    }
}
