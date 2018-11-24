package me.maiz.course.distributedsystem.rpcimpl.client;

import me.maiz.course.distributedsystem.rpcimpl.server.HelloService;
import me.maiz.course.distributedsystem.rpcimpl.server.HelloServiceImpl;

import java.net.InetSocketAddress;

public class RPCClient {
    public static void main(String[] args) {
        HelloService helloService = new RPCImporter<HelloServiceImpl>().getRPCProxy(HelloServiceImpl.class, new InetSocketAddress("localhost", 9999));
        System.out.println(System.currentTimeMillis()+" client :: "+helloService.sayHello("Lucas"));
    }
}
