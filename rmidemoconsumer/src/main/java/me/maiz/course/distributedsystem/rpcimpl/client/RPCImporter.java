package me.maiz.course.distributedsystem.rpcimpl.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

public class RPCImporter<S> {

    public S getRPCProxy(final Class<S> serviceClass, final InetSocketAddress addr){
        return (S) Proxy.newProxyInstance(serviceClass.getClassLoader(), new Class<?>[]{serviceClass.getInterfaces()[0]}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(System.currentTimeMillis()+ " client :: 生成代理对象");
                Socket socket = null;
                ObjectOutputStream output=null;
                ObjectInputStream input=null;

                socket = new Socket();
                System.out.println(System.currentTimeMillis()+ " client :: 连接"+addr);

                socket.connect(addr);
                output = new ObjectOutputStream(socket.getOutputStream());
                output.writeUTF(serviceClass.getName());
                output.writeUTF(method.getName());
                output.writeObject(method.getParameterTypes());
                output.writeObject(args);
                System.out.println(System.currentTimeMillis()+ " client :: 写出结束");

                input = new ObjectInputStream(socket.getInputStream());
                return input.readObject();
            }
        });
    }

}
