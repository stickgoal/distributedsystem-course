package me.maiz.ds.bootdemodubboconsumer;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@SpringBootApplication
@EnableDubboConfiguration
public class BootdemoDubboconsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootdemoDubboconsumerApplication.class, args);

    }

}
