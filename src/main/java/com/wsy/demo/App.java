package com.wsy.demo;
import com.wsy.study.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);

        RpcProxyClient rpcProxyClient = applicationContext.getBean(RpcProxyClient.class);

//        RpcProxyClient rpcProxyClient=new RpcProxyClient();
        HelloService helloService=rpcProxyClient.clientProxy
                (HelloService.class,"localhost",9090);
        String sayHello = helloService.sayHello("wang");

        System.out.println(sayHello);
    }
}
