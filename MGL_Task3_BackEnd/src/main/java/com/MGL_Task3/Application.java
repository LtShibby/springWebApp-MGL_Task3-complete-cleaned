package com.MGL_Task3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.MGL_Task3.configuration.JpaConfiguration;

@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages = { "com.MGL_Task3" })
@ComponentScan("com.MGL_Task3.*")
@EntityScan("com.MGL_Task3.model")
public class Application {
    public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
    }
}
