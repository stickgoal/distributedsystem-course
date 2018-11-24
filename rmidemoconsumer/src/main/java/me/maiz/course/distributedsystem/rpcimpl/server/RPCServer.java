package me.maiz.course.distributedsystem.rpcimpl.server;

public class RPCServer {
    public static void main(String[] args) {
        new RPCExporter().exportService("localhost",9999);
    }
}
