package com.qianyang.ayio2o.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.qianyang.ayio2o.R;
import com.qianyang.ayio2o.connServer.PostServer;

/**
 * 找回密码
 * Created by YangYang on 2015/12/19.
 */
public class ResetActivity extends Activity implements OnClickListener {
    private Button btn_resetPwdOK;//完成按钮
    /*private EditText edit_resetName;//用户名*/
    private EditText edit_resetPwd;//密码
    private EditText edit_resetPwd2;//密码确认
    private String userPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resetpwd_layout);
        //控件初始化
        edit_resetPwd = (EditText) findViewById(R.id.edit_resetPwd);
        edit_resetPwd2 = (EditText) findViewById(R.id.edit_resetPwd);
        /*edit_resetName = (EditText) findViewById(R.id.edit_resetName);*/
        btn_resetPwdOK = (Button) findViewById(R.id.btn_resetPwdOK);
        //添加点击事件
        btn_resetPwdOK.setOnClickListener(this);
        Intent intent = ResetActivity.this.getIntent();
        userPhone = getString(intent.getStringExtra("userPhone"));
        Log.d("TAG","userPhone:"+userPhone);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_resetPwdOK:
                reSet();//判断是否未输入
                break;
        }
    }

    //判空
    private void reSet() {
        /*String strName = getString(edit_resetName.getText().toString());*/
        String strPwd = getString(edit_resetPwd.getText().toString());
        String strPwd2 = getString(edit_resetPwd2.getText().toString());
        if (strPwd != null && strPwd2 != null) {
            if (strPwd.equals(strPwd2)) {

                int flag = new PostServer().sendResetPwdMsg(userPhone,strPwd);
                if (flag == 1){
                    Toast.makeText(getApplicationContext(), "密码修改成功", Toast.LENGTH_SHORT).show();
                    Log.d("TAG", "<<<<<<<<密码修改成功");
                    Intent intent = new Intent();
                    intent.setClass(ResetActivity.this,LoginActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "密码修改失败", Toast.LENGTH_SHORT).show();
                    Log.d("TAG","<<<<<<<<密码修改失败");
                }
            } else {
                Toast.makeText(getApplicationContext(), "密码确认错误", Toast.LENGTH_SHORT).show();
                Log.d("TAG","<<<<<<<<密码确认错误");
            }
        } else {
            Toast.makeText(getApplicationContext(), "资料填写不完整", Toast.LENGTH_SHORT).show();
            Log.d("TAG", "<<<<<<<<<资料填写不完整");
        }
    }

    //返回登陆界面
    private void returnLogin() {
        Intent intent = new Intent(ResetActivity.this, LoginActivity.class);
        ResetActivity.this.startActivity(intent);
        ResetActivity.this.finish();
    }

    private String getString(String str) {
        if ((str.trim()).equals("")) {
            return null;
        }
        return str.trim();
    }

    @Override
    protected void onPause() {
        ResetActivity.this.finish();
        super.onPause();
    }
}
