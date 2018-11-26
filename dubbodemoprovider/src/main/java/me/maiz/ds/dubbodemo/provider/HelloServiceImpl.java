package me.maiz.ds.dubbodemo.provider;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloServiceImpl implements HelloService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String sayHello(String name) {
        logger.info("访问，参数为{}",name);
        return "Hello "+name;
    }
}
