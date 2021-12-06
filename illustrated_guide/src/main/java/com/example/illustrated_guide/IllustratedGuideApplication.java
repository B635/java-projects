package com.example.illustrated_guide;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.illustrated_guide.mapper")
public class IllustratedGuideApplication {

    public static void main(String[] args) {
        SpringApplication.run(IllustratedGuideApplication.class, args);
    }

}
