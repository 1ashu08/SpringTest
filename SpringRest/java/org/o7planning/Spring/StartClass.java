package org.o7planning.Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;

@EnableEntityLinks

@EnableHypermediaSupport(type = HypermediaType.HAL)

@SpringBootApplication

public class StartClass {

    public static void main(String[] args) {

        SpringApplication.run(StartClass.class, args);

    }

}