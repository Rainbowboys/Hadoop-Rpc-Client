package com.nciae.bigdata.rpc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * 请求远程服务
 */
public class LoginClient {
    public static void main(String[] args) throws IOException {

        /*set the home of hadoop in windows and need  winutils.exe  windows */
        System.setProperty("hadoop.home.dir", "C:/Program Files/hadoop-2.6.0/hadoop-2.6.0");

          //获取远程的服务实现 本地 就好像 调用本地的方法实现一样
        LoginServerProtocolInterface proxy = RPC.getProxy(LoginServerProtocolInterface.class,999 , new InetSocketAddress("192.168.145.199", 10000), new Configuration());
      boolean flag=  proxy.login("xiaozhang","1234567");
        if(flag){

            System.out.println("小张好棒");
        }else {

            System.out.println("login fail");
        }

        /**
         * 优雅的关闭RPC
         */

        RPC.stopProxy(proxy);
    }


}
