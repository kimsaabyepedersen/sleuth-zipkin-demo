package org.saabye_pedersen.demos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@SpringBootApplication
@RestController
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @RequestMapping("/")
    public String home() {
        LOGGER.info("Request to / endpoint");
        return "Hello World";
    }


    @RequestMapping("/getTime")
    public String getTime() {
        LOGGER.info("Request to /getTime endpoint");
        return getTimeAsString();
    }

    private String getTimeAsString() {
        LOGGER.info("Returning time as String");
        return LocalDateTime.now().toString();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
