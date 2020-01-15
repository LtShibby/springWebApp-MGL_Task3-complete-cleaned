package com.MGL_Task3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = { HibernateJpaAutoConfiguration.class })
@ComponentScan("com.MGL_Task3")
public class Application {
    public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
    }
}
