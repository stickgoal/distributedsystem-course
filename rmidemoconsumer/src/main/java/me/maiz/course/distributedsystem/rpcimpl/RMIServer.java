package me.maiz.course.distributedsystem.rpcimpl;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class RMIServer {

    public static void main(String[] args) {

    }

    private static void exportService(String hostName,int  port){
        ServerSocket serverSocket = null;
        ObjectInputStream in =null;
        ObjectOutputStream out = null;
        try {
            serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(hostName,port));
        while(true){
            Socket client = serverSocket.accept();
             in = new ObjectInputStream(client.getInputStream());
            String interfaceName = in.readUTF();
            String methodName = in.readUTF();
            Class<?>[] parameterTypes = (Class<?>[]) in.readObject();
            Object[] params = (Object[]) in.readObject();
            Class<?> service = Class.forName(interfaceName);
            Method method = service.getMethod(methodName,parameterTypes);
            Object result = method.invoke(service.newInstance(),params);
            out= new ObjectOutputStream(client.getOutputStream());
            out.writeObject(result);
        }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }finally{
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
