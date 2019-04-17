package com.util;

import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

@EnableEntityLinks

//@EnableHypermediaSupport(type = HypermediaType.HAL)

@SpringBootApplication

public class StartClass {

    public static void main(String[] args) {

        SpringApplication.run(StartClass.class, args);
        //org.springframework.util.Assert.isTrue(false);

    }

}