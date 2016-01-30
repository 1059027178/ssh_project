package com.qianyang.ayio2o.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.qianyang.ayio2o.R;
import com.qianyang.ayio2o.connServer.PostServer;

/**
 * Created by YangYang on 2015/12/19.
 */
public class LoginActivity extends Activity implements OnClickListener {

    private Button login_btn;//登陆按钮
    private EditText login_name,login_psd;//登录名，登陆密码
    private TextView text_forget,text_zhuce;//找回密码，注册账户
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        init();//控件初始化
    }
    //初始化控件
    private void init() {
        //获得控件
        login_btn  = (Button) findViewById(R.id.login_button);
        login_name = (EditText) findViewById(R.id.login_name);
        login_psd  = (EditText) findViewById(R.id.login_password);
        text_forget= (TextView) findViewById(R.id.forget_text);
        text_zhuce = (TextView) findViewById(R.id.zhuce_text);
        //添加事件
        login_btn.setOnClickListener(this);
        text_forget.setOnClickListener(this);
        text_zhuce.setOnClickListener(this);
    }
    //事件处理
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_button:
                login();//判断登录名，密码是否输入为空
                break;
            case R.id.forget_text:
                resetPwd();//跳转到重置密码界面
                break;
            case R.id.zhuce_text:
                regeditName();//进入注册界面
                break;
        }
    }
    //判断登录名，密码是否输入为空
    private void login() {
        String name = getString(login_name.getText().toString());
        String pwd = getString(login_psd.getText().toString());
        if (name != null && pwd != null){
            //提交登陆信息
            int flag = new PostServer().sendLoginMsg(name,pwd);
            if (flag == 1){
                Toast.makeText(getApplicationContext(),R.string.info_success,Toast.LENGTH_SHORT).show();
                Log.d("TAG", ">>>>>>>>>登陆成功，flag：" + flag);
                Intent intent = new Intent();
                intent.putExtra("userName",name);
                intent.putExtra("userPwd",pwd);
                intent.setClass(LoginActivity.this,MainActivity.class);
                LoginActivity.this.startActivity(intent);
                LoginActivity.this.finish();
            }else {
                Log.d("TAG",">>>>>>>>>登陆失败，flag："+flag);
                Toast.makeText(getApplicationContext(),R.string.info_fail,Toast.LENGTH_SHORT).show();
            }
        } else {
            //用户名，密码登陆验证
            Toast.makeText(getApplicationContext(),R.string.info_login,Toast.LENGTH_SHORT).show();
        }
    }
    //进入重置密码界面
    private void resetPwd(){
        String flag = "reset";
        Intent intent = new Intent();
        intent.putExtra("flag", flag);
        intent.setClass(LoginActivity.this, PhoneYZActivity.class);
        LoginActivity.this.startActivity(intent);
    }
    //进入注册界面
    private void regeditName(){
        String flag = "zhuce";
        Intent intent = new Intent();
        intent.putExtra("flag", flag);
        intent.setClass(LoginActivity.this, PhoneYZActivity.class);
        LoginActivity.this.startActivity(intent);
    }
    private String getString(String str){
        if ((str.trim()).equals("")) return null;
        return  str.trim();
    }
}
