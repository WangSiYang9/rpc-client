package com.wsy.demo;

import com.wsy.study.RpcRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 王思洋
 * @version 1.0
 * @date 2019-06-12 10:25
 */
public class RemoteInvocationHandler implements InvocationHandler {

    private String host;
    private int port;

    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //请求数据的包装
        RpcRequest rpcRequest=new RpcRequest();
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setPatameters(args);
        rpcRequest.setVersion("v1.0");

        RpcNetTransport rpcNetTransport =new RpcNetTransport(host,port);
        Object result = rpcNetTransport.send(rpcRequest);
        return result;
    }
}
