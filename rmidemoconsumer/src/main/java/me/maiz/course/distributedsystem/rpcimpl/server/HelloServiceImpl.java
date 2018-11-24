package me.maiz.course.distributedsystem.rpcimpl.server;

public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        System.out.println("server :: "+name+" come in ,I will say hello to him");
        return "Hello "+name+"!";
    }

}
