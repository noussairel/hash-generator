package com.noussair.todoapp;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@SpringBootApplication
@EnableScheduling
public class TodoAppApplication {
    private static final Logger logger = LoggerFactory.getLogger(TodoAppApplication.class);

    private final Environment env;
    public TodoAppApplication(Environment env){
        this.env = env;
    }

    public static void main(String[] args) {
        SpringApplication.run(TodoAppApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady(){
        String port = env.getProperty("local.server.port", env.getProperty("server.port", "8080"));
        logger.info("server Started in port {}", port);
    }

    @RestController
    static class RootController{
        @GetMapping("/")
        public String root(){
            return "todo app";
        }
    }

}
