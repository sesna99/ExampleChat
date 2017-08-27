package com.example.admin.examplechat;

/**
 * Created by admin on 2017-08-26.
 */

public class Util {
    public static Util instance = new Util();
    private String userName;
    private String imei;

    public static void setInstance(Util instance) {
        Util.instance = instance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static Util getInstance() {
        return instance;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }
}
