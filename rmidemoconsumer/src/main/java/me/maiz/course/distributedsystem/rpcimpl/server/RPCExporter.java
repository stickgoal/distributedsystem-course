package me.maiz.course.distributedsystem.rpcimpl.server;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class RPCExporter {

    public void exportService(String hostName, int port) {
        System.out.println(String.format("server :: 准备暴露服务%s:%n", hostName,port));
        ServerSocket serverSocket = null;
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        Socket client = null;
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(hostName, port));
            while (true) {
                System.out.println(String.format(System.currentTimeMillis()+" server :: 监听 %s:%n", hostName,port));

                client = serverSocket.accept();
                System.out.println(System.currentTimeMillis()+" server :: 有客户端接入");
                in = new ObjectInputStream(client.getInputStream());
                String interfaceName = in.readUTF();
                String methodName = in.readUTF();
                Class<?>[] parameterTypes = (Class<?>[]) in.readObject();
                Object[] params = (Object[]) in.readObject();
                Class<?> service = Class.forName(interfaceName);
                Method method = service.getMethod(methodName, parameterTypes);
                Object result = method.invoke(service.newInstance(), params);
                out = new ObjectOutputStream(client.getOutputStream());
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
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
                if (serverSocket != null) {
                    serverSocket.close();
                }
                if (client != null) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
