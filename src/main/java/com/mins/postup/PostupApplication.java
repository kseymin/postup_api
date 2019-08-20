package com.mins.postup;


import com.mins.postup.service.DataServiceImpl;
import com.mins.postup.storage.StorageProperties;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class PostupApplication {

    public static void main(String[] args) {

        SpringApplication.run(PostupApplication.class, args);

    }
    @Bean
    CommandLineRunner init(DataServiceImpl dataService) {
        return (args) -> {
            dataService.deleteAll();
            dataService.init();
        };
    }

}
