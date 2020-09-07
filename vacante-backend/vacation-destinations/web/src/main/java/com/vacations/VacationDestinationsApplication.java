package com.vacations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.vacations"})
@EnableJpaRepositories(basePackages = {"com.vacations"})
@EntityScan(basePackages = {"com.vacations"})
public class VacationDestinationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(VacationDestinationsApplication.class, args);
    }
}
