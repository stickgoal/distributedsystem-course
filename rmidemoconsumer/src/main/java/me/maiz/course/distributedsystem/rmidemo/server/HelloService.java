package me.maiz.course.distributedsystem.rmidemo.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 服务端服务，要点：
 * TODO
 */
public interface HelloService  extends Remote {
    String sayHello(String message) throws RemoteException;
}
