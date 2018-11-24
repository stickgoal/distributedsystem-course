package me.maiz.course.distributedsystem.rmidemo.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * TODO 实现要点
 */
public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {

    protected HelloServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello(String name) throws RemoteException {
        System.out.println("server :: "+name+" come in ,I will say hello to him");
        return "Hello "+name+"!";
    }
}
