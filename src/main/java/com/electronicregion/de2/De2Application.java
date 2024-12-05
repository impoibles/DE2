package com.electronicregion.de2;

import com.electronicregion.de2.models.DismissedEmpoyeesEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.electronicregion.de2.repositories")

@SpringBootApplication
public class De2Application {

    public static void main(String[] args) {
        SpringApplication.run(De2Application.class, args);
    }

}
