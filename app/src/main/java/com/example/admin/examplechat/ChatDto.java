package com.example.admin.examplechat;

/**
 * Created by admin on 2017-08-26.
 */

public class ChatDto {
    private String userName;
    private String message;
    private String imei;

    public ChatDto() {
    }

    public ChatDto(String userName, String message, String imei) {
        this.userName = userName;
        this.message = message;
        this.imei = imei;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }
}
