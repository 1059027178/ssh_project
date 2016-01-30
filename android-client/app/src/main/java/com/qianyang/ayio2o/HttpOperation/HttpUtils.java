package com.qianyang.ayio2o.HttpOperation;

import android.util.Log;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * 连接服务器工具
 *
 * @author Fanff
 */
public class HttpUtils {
    public static final String ADRESS = "http://wxstudy.tunnel.qydev.com/JsonProject/servlet/JsonAction?action_flag=ACTION_FLAG";//测试时必须修改此参数

    public HttpUtils() {

        // TODO Auto-generated constructor stub
    }
    /**
     * 发起https请求并获取结果
     * @param outputStr  提交的数据
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
     */
    public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setRequestMethod(requestMethod);
            httpUrlConn.setConnectTimeout(10000);
            httpUrlConn.setReadTimeout(10000);
            if ("GET".equals(requestMethod)){
                httpUrlConn.connect();
            }
            // 当有数据需要提交时
            if (null != outputStr) {
                Log.d("TAG", "+++++++++httpUrlConn：" + httpUrlConn);
                OutputStream outputStream = httpUrlConn.getOutputStream();
                ObjectOutputStream objOutputStrm = new ObjectOutputStream(outputStream);
                // 注意编码格式，防止中文乱码
                objOutputStrm.writeObject(outputStr.getBytes("UTF-8"));
                objOutputStrm.flush();
                objOutputStrm.close();
            }
            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
            jsonObject.put("requestResult", buffer.toString());

        } catch (Exception e) {
            Log.d("TAG","+++++++++APP server connection timed out>>>>>>");
        }

        return jsonObject;
    }
}

