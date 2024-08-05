package com.manageruser.user;

import com.manageruser.sharedmodel.mongojpa.EnableMongoJpa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoJpa
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.manageruser.user.*",
        "com.manageruser.sharedmodel.*"
})
@EnableMongoRepositories(basePackages = {
        "com.manageruser.user.repository"
})
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}
