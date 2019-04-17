package com.util;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;

@EnableEntityLinks

@EnableHypermediaSupport(type = HypermediaType.HAL)

@SpringBootApplication

public class StartClass {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(StartClass.class, args);
       // SpringApplication.main(args);

    	//AbstractApplicationContext context = new AnnotationConfigApplicationContext(StartClass.class);
        //HelloWorld bean = (HelloWorld) context.getBean("helloWorldBean");
        //bean.sayHello("Spring 4");
        //context.close();
    	
    }

}