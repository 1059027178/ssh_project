package com.qianyang.ayio2o.connServer;

import android.util.Log;

import com.qianyang.ayio2o.HttpOperation.HttpUtil;
import com.qianyang.ayio2o.HttpOperation.TheadDAO;

/**
 * Created by YangYang on 2015/12/29.
 */

public class ServerTools {
    /**
     * 服务端返回数据处理
     * @param url
     * @return
     */
    public int returnServerFlag(String url){
        int flag = 0;
        TheadDAO.closeStrictMode();
        String jsResult = HttpUtil.sendHttpRequst(url);
        jsResult = jsResult.substring(0, 3);
        Log.d("TAG", ">>>>>>>>>服务端返回:jsResult=" + jsResult);
        if (jsResult.trim().equals("YES")) {
            flag = 1;
        }
        else if (jsResult.trim().equals("NOO")){
            flag = 0;
        }
        return flag;
    }
}
