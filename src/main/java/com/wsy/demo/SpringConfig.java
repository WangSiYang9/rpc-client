package com.wsy.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 王思洋
 * @version 1.0
 * @description
 * @date 2019-06-23 20:00
 */
@Configuration
public class SpringConfig {

    @Bean(name = "rpcProxyClient")
    public RpcProxyClient rpcProxyClient(){
        return new RpcProxyClient();
    }

}
