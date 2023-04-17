package com.zufe.yt.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yt
 */
@SpringBootApplication
@ComponentScan({"com.zufe.yt.person", "com.zufe.yt.common"})
public class PersonApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonApplication.class, args);
    }

}
