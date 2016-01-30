package com.qianyang.ayio2o.HttpOperation;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * 用来连接服务器
 *
 * @author Fanff
 */
public class HttpUtil {
    public static final String ADRESS = "http://wxstudy.tunnel.qydev.com/AYIServer/servlet/JsonAction?action_flag=ACTION_FLAG";//测试时必须修改此参数

    public HttpUtil() {
        // TODO Auto-generated constructor stub
    }
    public static String sendHttpRequst(String address) {
        try {
            URL url = new URL(address);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(8000);
            connection.setReadTimeout(8000);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-type", "text/html");
            connection.setRequestProperty("Accept-Charset", "utf-8");
            connection.setRequestProperty("contentType", "utf-8");

            int code = connection.getResponseCode();
            if (code == 200) {
                Log.i("TAG", "++++++++++++++连接服务器成功");
                return changeInputStream(connection.getInputStream());
            }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
        return null;
    }
    private static String changeInputStream(InputStream inputStream) {
        // TODO Auto-generated method stub
        String jsonString = "";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int len = 0;
        byte[] data = new byte[1024];
        try {
            while ((len = inputStream.read(data)) != -1) {
                outputStream.write(data, 0, len);
            }
            jsonString = new String(outputStream.toByteArray());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonString;
    }
}


