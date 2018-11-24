package me.maiz.course.distributedsystem.rmidemo.client;

import me.maiz.course.distributedsystem.rmidemo.server.HelloService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIClient {

    public static void main(String[] args) {
        try {
            System.out.println("client :: 查找RMI服务[rmi://127.0.0.1:9999/Hello]...");
            HelloService hs = (HelloService) Naming.lookup("rmi://127.0.0.1:9999/Hello");
           String result = hs.sayHello("Lucas");
            System.out.println("client :: "+result);
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
