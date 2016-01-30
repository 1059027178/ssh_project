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
 * 注册账号
 * Created by YangYang on 2015/12/19.
 */
public class RegeditActivity extends Activity implements OnClickListener {
    private EditText edit_setName = null;//用户名
    private EditText edit_setPwd = null;//密码
    private EditText edit_setPwd2 = null;//确认密码
    private Button btn_getRegedit = null;//注册按钮
    private String strPhone = null;//手机号
    private String strName = null;//登陆名
    private String strPwd = null;//密码
    private String strPwd2 = null;//确认密码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regedit_layout);
        //控件初始化
        edit_setName = (EditText) findViewById(R.id.edit_setName);//用户名
        edit_setPwd = (EditText) findViewById(R.id.edit_setPwd);//密码
        edit_setPwd2 = (EditText) findViewById(R.id.edit_setPwd2);//确认密码
        btn_getRegedit = (Button) findViewById(R.id.btn_regedit);//注册按钮
        Intent intent = this.getIntent();
        strPhone = intent.getStringExtra("phone");
        //添加点击事件
        btn_getRegedit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_regedit:
                sendMsg();
                break;
        }
    }

    //输入值验证
    private void sendMsg() {
        strName = getString(edit_setName.getText().toString().trim());
        strPwd = getString(edit_setPwd.getText().toString().trim());
        strPwd2 = getString(edit_setPwd2.getText().toString().trim());
        if (strName != null && strPwd != null && strPwd2 != null) {
            int flag = new PostServer().sendNameMsg(strName);
            if (flag == 0) {
                if (strPwd.equals(strPwd2)) {//提交信息
                    int flag1 = new PostServer().sendRegeditMsg(strName, strPwd, strPhone);//发送注册信息
                    Log.d("TAG", ">>>>>>>>发送状况为" + flag);
                    if (flag1 == 1) {
                        Log.d("TAG", ">>>>>>>>注册成功" + flag);
                        Toast.makeText(getApplicationContext(), R.string.seccess1, Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(RegeditActivity.this, LoginActivity.class);
                        RegeditActivity.this.startActivity(intent1);
                        RegeditActivity.this.finish();
                    } else {
                        Log.d("TAG", ">>>>>>>>注册失败" + flag);
                        Toast.makeText(getApplicationContext(), R.string.failed2, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), R.string.info_decidePwd, Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "该用户名已注册", Toast.LENGTH_SHORT).show();
            }
        } else if (strPwd.equals(strPwd2) == false) { //再次输入密码验证
            Toast.makeText(getApplicationContext(), R.string.info_regedit, Toast.LENGTH_SHORT).show();
        }
    }

    private String getString(String str) {
        if ((str.trim()).equals("")) {
            return null;
        }
        return str.trim();
    }
}
