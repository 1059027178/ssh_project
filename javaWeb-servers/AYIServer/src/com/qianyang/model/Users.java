package com.qianyang.model;
/**
 * 用户信息
 * Created by YangYang on 2015/12/23.
 */
public class Users {
    //------------------------------登陆注册需填写的信息----------------//

    private String userName;//用户名

    private String userPaswd;//用户密码

    private String userPhone;//用户手机号

    //------------------------------用户需登陆后完善的信息----------------//

    private String userZWM;//个人中文名

    private String userSex;//性别

    private String userCard;//个人证件号

    private String userAddress;//联系地址

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPaswd() {
        return userPaswd;
    }

    public void setUserPaswd(String userPaswd) {
        this.userPaswd = userPaswd;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserZWM() {
        return userZWM;
    }

    public void setUserZWM(String userZWM) {
        this.userZWM = userZWM;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserCard() {
        return userCard;
    }

    public void setUserCard(String userCard) {
        this.userCard = userCard;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
