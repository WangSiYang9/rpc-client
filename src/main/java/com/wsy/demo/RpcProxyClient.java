package com.wsy.demo;

import java.lang.reflect.Proxy;

/**
 * @author 王思洋
 * @version 1.0
 * @date 2019-06-12 09:19
 */
public class RpcProxyClient {


    public <T> T clientProxy(final Class<T> interfaceCls,final String host,final int port){

        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(),
                new Class<?>[]{interfaceCls},new RemoteInvocationHandler(host,port));
    }

}
