package com.qianyang.ayio2o.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.qianyang.ayio2o.R;
import com.qianyang.ayio2o.configMsg.SMSMsg;
import com.qianyang.ayio2o.connServer.PostServer;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

/**
 * Created by YangYang on 2015/12/27.
 */
public class PhoneYZActivity extends Activity implements View.OnClickListener {
    private static final String appkey = SMSMsg.getAPPKEY();
    private static final String appsecret = SMSMsg.getAPPSECRET();
    private Button btn_getYZM = null;//获取验证码
    private Button btn_next = null;//下一步
    private EditText edit_inputYZM = null;//验证码
    private EditText edit_getphone = null;//手机号
    private EventHandler eh;//mobsdk
    private TimeCount time;
    private String flag = null;//页面跳转标志：zhuce注册事件；忘记密码：reset
    private boolean sendFlag = false;//验证码发送标志

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phoneyz_layout);
        //初始化短信SDK
        SMSSDK.initSDK(this, appkey, appsecret);
        btn_getYZM = (Button) findViewById(R.id.btn_getYZM);
        btn_next = (Button) findViewById(R.id.btn_next);
        edit_inputYZM = (EditText) findViewById(R.id.edit_inputYZM);
        edit_getphone = (EditText) findViewById(R.id.edit_getphone);
        btn_getYZM.setOnClickListener(this);
        btn_next.setOnClickListener(this);
        Intent intent1 = this.getIntent();//--------------------------
        flag = intent1.getStringExtra("flag");
        Log.d("TAG", ">>>>>>>>事件类型：" + flag);
        time = new TimeCount(60000, 1000);
        eh = new EventHandler() {
            @Override
            public void afterEvent(int event, int result, Object data) {
                Message msg = new Message();
                msg.arg1 = event;
                msg.arg2 = result;
                msg.obj = data;
                handler.sendMessage(msg);
            }
        };
        SMSSDK.registerEventHandler(eh); //回调函数
    }

    @Override
    public void onClick(View v) {
        String strPhone = getString(edit_getphone.getText().toString());
        switch (v.getId()) {
            case R.id.btn_getYZM://获取验证码
                if (strPhone != null && strPhone.length() == 11) {
                    //验证手机号是否已被注册
                    time.start();
                    if (flag.equals("zhuce")) {
                        int flag1 = new PostServer().sendPhoneMsg(strPhone);
                        if (flag1 == 0) {
                            if (flag.equals("reset")){
                                Toast.makeText(getApplicationContext(), "该手机未注册", Toast.LENGTH_SHORT).show();
                            }
                            SMSSDK.getVerificationCode("86", strPhone);//获取验证码
                            Log.d("TAG", ">>>>>>>>>>正在发送验证码");
                        } else if (flag1 == 1) {
                            if (flag.equals("zhuce")){
                                Toast.makeText(getApplicationContext(), "该手机号已被注册", Toast.LENGTH_SHORT).show();
                                Log.d("TAG", ">>>>>>>>>>该手机号已被注册：flag1 =" + flag1);
                            }
                        }
                    } else if (flag.equals("reset")) {
                        int flag1 = new PostServer().sendPhoneMsg(strPhone);
                        if (flag1 == 1) {
                            Toast.makeText(getApplicationContext(), "该手机已注册", Toast.LENGTH_SHORT).show();
                            SMSSDK.getVerificationCode("86", strPhone);//获取验证码
                            Log.d("TAG", ">>>>>>>>>>正在发送验证码");
                        } else if (flag1 == 0) {
                            Toast.makeText(getApplicationContext(), "该手机号未注册", Toast.LENGTH_SHORT).show();
                            Log.d("TAG", ">>>>>>>>>>该手机号未注册：flag1 =" + flag1);
                        }
                    }
                } else {
                    Toast.makeText(getApplicationContext(), R.string.info_phone2, Toast.LENGTH_SHORT).show();
                    Log.d("TAG", ">>>>>>>>>>手机号错误");
                }
                break;
            case R.id.btn_next://发送验证码
               /*测试代码*/
                /*if (flag.equals("zhuce")){
                    Intent intent = new Intent();
                    String strPhone1 = edit_getphone.getText().toString().trim();
                    intent.putExtra("phone",strPhone1);
                    intent.setClass(PhoneYZActivity.this, RegeditActivity.class);
                    startActivity(intent);
                    this.finish();
                    SMSSDK.unregisterEventHandler(eh);//注销函数
                }else if (flag.equals("reset")){
                    Intent intent = new Intent();
                    String strPhone1 = edit_getphone.getText().toString().trim();
                    intent.putExtra("phone",strPhone1);
                    intent.setClass(PhoneYZActivity.this, ResetActivity.class);
                    startActivity(intent);
                    this.finish();
                }*/
                /*测试代码*/
                String strYZM = edit_inputYZM.getText().toString().trim();
                SMSSDK.registerEventHandler(eh); //回调函数
                if (sendFlag == true) {
                    if (strYZM != null || strYZM != "") {
                        SMSSDK.submitVerificationCode("86", strPhone, strYZM); //提交验证码
                        SMSSDK.registerEventHandler(eh); //回调函数
                    } else {
                        Log.d("TAG", ">>>>>>>>>>未填写验证码");
                        Toast.makeText(getApplicationContext(), R.string.info_YZM, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.d("TAG", ">>>>>>>>>>验证码还未发送");
                    Toast.makeText(getApplicationContext(), R.string.failed1, Toast.LENGTH_SHORT).show();
                }
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int event = msg.arg1;
            int result = msg.arg2;
            Object data = msg.obj;
            if (result == SMSSDK.RESULT_COMPLETE) {
                //短信注册成功后，返回MainActivity,然后提示新好友
                if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                    sendFlag = true;
                    Toast.makeText(getApplicationContext(), "验证码已经发送", Toast.LENGTH_SHORT).show();
                    Log.d("TAG", ">>>>>>>>>验证码已经发送:" + sendFlag);
                } else if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                    String strPhone = edit_getphone.getText().toString().trim();
                    if (flag.equals("zhuce")) {
                        Log.d("TAG", ">>>>>>>>>进入资料填写页面");
                        Toast.makeText(getApplicationContext(), R.string.seccess, Toast.LENGTH_SHORT).show();
                        Log.d("TAG", ">>>>>>>>>验证成功:" + sendFlag);
                        Intent intent = new Intent();
                        intent.putExtra("phone", strPhone);
                        intent.setClass(PhoneYZActivity.this, RegeditActivity.class);
                        startActivity(intent);
                        PhoneYZActivity.this.finish();
                        SMSSDK.unregisterEventHandler(eh);//注销函数
                    } else if (flag.equals("reset")) {
                        Intent intent = new Intent();
                        intent.putExtra("userPhone", strPhone);
                        intent.setClass(PhoneYZActivity.this, ResetActivity.class);
                        startActivity(intent);
                        PhoneYZActivity.this.finish();
                        SMSSDK.unregisterEventHandler(eh);//注销函数
                    }
                }
            } else {
                ((Throwable) data).printStackTrace();
                Toast.makeText(getApplicationContext(), R.string.failed, Toast.LENGTH_SHORT).show();
            }
        }
    };

    class TimeCount extends CountDownTimer {//计时

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {//计时过程
            btn_getYZM.setClickable(false);//屏蔽按钮，防止重复点击
//            btn_getYZM.setBackgroundColor();
            btn_getYZM.setText("(" + millisUntilFinished / 1000 + "秒)后重新获取");
        }

        @Override
        public void onFinish() {//计时完成
//            btn_getYZM.setBackgroundColor();
            btn_getYZM.setText(R.string.authCodBtn);
            btn_getYZM.setClickable(true);
        }
    }

    private String getString(String str) {
        if ((str.trim()).equals("")) {
            return null;
        }
        return str.trim();
    }
}
