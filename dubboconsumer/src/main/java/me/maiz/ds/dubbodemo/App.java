package me.maiz.ds.dubbodemo;

import me.maiz.ds.dubbodemo.provider.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        context.start();
        HelloService hs = context.getBean(HelloService.class);
        System.out.println(hs.sayHello("Lina"));
    }
}
