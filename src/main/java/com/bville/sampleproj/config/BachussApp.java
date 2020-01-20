/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bville.sampleproj.config;

import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author Bart
 */
@SpringBootApplication
public class BachussApp {

    boolean logBeans = false;

    public static void main(String[] args) {
        SpringApplication.run(BachussApp.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            if (logBeans) {
                System.out.println("Let's inspect the beans provided by Spring Boot:");
            }

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                if (logBeans) {
                    System.out.println(beanName);
                }
            }

        };
    }
}
