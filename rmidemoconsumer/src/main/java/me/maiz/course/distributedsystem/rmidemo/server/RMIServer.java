package me.maiz.course.distributedsystem.rmidemo.server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RMIServer {
    public static void main(String[] args) {
        System.out.println("server :: "+"启动RMI服务端");
        try {
            HelloService helloService = new HelloServiceImpl();
            System.out.println("server :: "+"绑定服务到端口9999");
            LocateRegistry.createRegistry(9999);
            Naming.bind("rmi://127.0.0.1:9999/Hello",helloService);
        } catch (RemoteException | MalformedURLException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
