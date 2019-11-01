package com.capacity.spit;

import com.capacity.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MongoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MongoApplication.class);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1, 1);
    }

}
