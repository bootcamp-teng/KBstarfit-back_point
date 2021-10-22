package com.starfit.point;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

@EnableScheduling
@SpringBootApplication
public class MvpSampleSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvpSampleSpringbootApplication.class, args);
	}
	
    @Bean
    public TaskScheduler taskScheduler() {
        return new ConcurrentTaskScheduler();
    }	

}
