package com.mackittipat.bootaop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {

    private final static Logger log = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        log.info("Running ...");
        userService.findUser(9);
    }
}
