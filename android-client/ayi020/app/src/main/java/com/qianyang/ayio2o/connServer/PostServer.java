package com.qianyang.ayio2o.connServer;

import android.util.Log;

import com.qianyang.ayio2o.HttpOperation.HttpUtil;
import com.qianyang.ayio2o.configMsg.OperationTypeMsg;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by YangYang on 2015/12/23.
 */
public class PostServer {
    private ServerTools tools = new ServerTools();

    /**
     * 将注册信息发送服务端，完成注册
     * @param userName
     * @param userPwd
     * @param strPhone
     * @return true(注册成功);
     */
    public int sendRegeditMsg(String userName, String userPwd, String strPhone) {
        int flag = 0;
        String url = ((HttpUtil.ADRESS).replace("ACTION_FLAG", OperationTypeMsg.regedit));//服务器地址
        try {
            url += "&userName=" + URLEncoder.encode(userName, "UTF-8") + "&userPwd="
                    + URLEncoder.encode(userPwd, "UTF-8") + "&userPhone="
                    + URLEncoder.encode(strPhone, "UTF-8");
            //添加响应标志
            Log.d("TAG", "+++++++正在注册...");
            flag = tools.returnServerFlag(url);
            return flag;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 发送登陆信息
     * @param userName
     * @param userPwd
     * @return
     */
    public int sendLoginMsg(String userName, String userPwd) {
        String url = HttpUtil.ADRESS.replace("ACTION_FLAG", OperationTypeMsg.login);//服务器地址
        int flag = 0;//0:失败；1成功
        try {
            url += "&userName=" + URLEncoder.encode(userName, "UTF-8") + "&userPwd="
                    + URLEncoder.encode(userPwd, "UTF-8");
            Log.d("TAG", ">>>>>>>>>正在登陆...");
            Log.d("TAG", ">>>>>>>>URL：" + url);
            flag = tools.returnServerFlag(url);
            return flag;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 发送重置密码信息
     * @param userPhone
     * @param userNewPwd
     * @return
     */
    public int sendResetPwdMsg(String userPhone, String userNewPwd) {
        String url = HttpUtil.ADRESS.replace("ACTION_FLAG", OperationTypeMsg.forgetPwd);
        int flag = 0;
        try {
            url += "&userNewPwd=" + URLEncoder.encode(userNewPwd, "UTF-8") + "&userPhone="
                    + URLEncoder.encode(userPhone, "UTF-8");
            Log.d("TAG", "url:" + url);
            Log.d("TAG", "<<<<<<<<重置信息发送中");
            flag = tools.returnServerFlag(url);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 手机验证（唯一性验证）
     * @param userPhone
     * @return
     */
    public int sendPhoneMsg(String userPhone) {
        String url = HttpUtil.ADRESS.replace("ACTION_FLAG", OperationTypeMsg.desidePhone);
        int flag = 0;
        try {
            url += "&userPhone=" + URLEncoder.encode(userPhone, "UTF-8");
            Log.d("TAG", "<<<<<<<<手机号码验证中");
            flag = tools.returnServerFlag(url);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 发送服务端用户名唯一性验证
     * @param userName
     * @return
     */
    public int sendNameMsg(String userName) {
        String url = HttpUtil.ADRESS.replace("ACTION_FLAG", OperationTypeMsg.desideName);
        int flag = 0;
        try {
            url += "&userName=" + URLEncoder.encode(userName, "UTF-8");
            Log.d("TAG", "<<<<<<<<用户名验证中");
            flag = tools.returnServerFlag(url);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
