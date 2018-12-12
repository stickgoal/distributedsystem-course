package me.maiz.ds.multimodule.emallassemble;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class EmallAssembleApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmallAssembleApplication.class, args);
    }
}
