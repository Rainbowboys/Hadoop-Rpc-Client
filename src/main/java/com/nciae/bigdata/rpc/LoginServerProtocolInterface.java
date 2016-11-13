package com.nciae.bigdata.rpc;

/**
 *  用户登陆服务接口设计
 */
public interface LoginServerProtocolInterface {

    public boolean login(String username, String password);

    /**
     * 接口中必须定义一个常量：版本号
     */
    public static final long versionID = 999;


}
