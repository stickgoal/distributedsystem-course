package me.maiz.ds.multimodule;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class CoreAssembleApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreAssembleApplication.class, args);
    }
}
