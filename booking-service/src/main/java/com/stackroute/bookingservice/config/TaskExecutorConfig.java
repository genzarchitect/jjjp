package com.stackroute.bookingservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class TaskExecutorConfig {

    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(700);
        executor.setMaxPoolSize(2000);
        executor.setQueueCapacity(5000);
        executor.setThreadNamePrefix("BookingTaskExecutor-");
        executor.initialize();
        return executor;
    }
}