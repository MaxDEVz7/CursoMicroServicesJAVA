package com.max.hr_config_server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class HrConfigServerApplication implements CommandLineRunner {
    //	@Value("${GITHUB_TOKEN}")
//	String user;
    @Override
    public void run(String... args) throws Exception {
//		System.out.println("USER GITHUB -> " + user);
    }

    public static void main(String[] args) {
        SpringApplication.run(HrConfigServerApplication.class, args);
    }
}
