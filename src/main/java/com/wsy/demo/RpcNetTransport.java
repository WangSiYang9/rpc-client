package com.wsy.demo;

import com.wsy.study.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author 王思洋
 * @version 1.0
 * @date 2019-06-12 11:13
 */
public class RpcNetTransport {


    private String host;
    private int port;

    public RpcNetTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Object send (RpcRequest rpcRequest){
        Socket socket = null;
        Object result = null;

        ObjectOutputStream outputStream =null;
        ObjectInputStream inputStream =null;

        try {
            socket = new Socket(host,port);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(rpcRequest);

            outputStream.flush();


            inputStream = new ObjectInputStream(socket.getInputStream());
            result = inputStream.readObject();


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //关流
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }



        return result;
    }

}
