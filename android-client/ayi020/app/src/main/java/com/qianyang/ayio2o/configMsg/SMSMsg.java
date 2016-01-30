package com.qianyang.ayio2o.configMsg;

/**
 * 请注意：测试短信条数限制发送数量：20条/天，APP开发完成后请到mob.com后台提交审核，获得不限制条数的免费短信权限。
 * SMS密钥(http://sms.mob.com/)
 * 注册账号：1059027178@qq.com
 * 密码：105902178
 * Created by YangYang on 2015/12/20.
 */
public class SMSMsg {
    // 填写从短信SDK应用后台注册得到的APPKEY
    private final static String APPKEY= "da662bed3570";
    // 填写从短信SDK应用后台注册得到的APPSECRET
    private final static String APPSECRET= "423ee0129182b5cd86dbeb9860f268b1";

    public static String getAPPKEY() {

        return APPKEY;
    }
    public static String getAPPSECRET() {

        return APPSECRET;
    }
}
