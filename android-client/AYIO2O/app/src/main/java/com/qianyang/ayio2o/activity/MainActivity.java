package com.qianyang.ayio2o.activity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.qianyang.ayio2o.R;
import com.qianyang.ayio2o.fragment.FragmentHome;
import com.qianyang.ayio2o.fragment.FragmentMy;
import com.qianyang.ayio2o.fragment.FragmentOrder;
/**
 * Created by YangYang on 2015/12/27.
 */
public class MainActivity extends Activity{
    private Fragment[] fragments = new Fragment[3];
    private TextView textViewHead = null;
    private RadioGroup main_fragment_rgp;
    private Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        Intent intent = this.getIntent();
        activity = this.activity;
        String userName = intent.getStringExtra("userName");
        String userPwd = intent.getStringExtra("userPwd");
        Log.d("TAG", "userName>>>>>>>"+userName);
        Log.d("TAG", "userPwd >>>>>>>"+userPwd);
        fragments[0] = new FragmentMy();   //个人信息
        fragments[1] = new FragmentHome();//主页信息
        fragments[2] = new FragmentOrder();//订单管理
        getFragmentManager().beginTransaction()
                .add(R.id.main_fragment, fragments[0])
                .add(R.id.main_fragment, fragments[1])
                .add(R.id.main_fragment, fragments[2]).commit();
        textViewHead = (TextView) findViewById(R.id.title_heard);
        main_fragment_rgp = (RadioGroup) findViewById(R.id.main_fragment_rgp);
        main_fragment_rgp.check(R.id.main_rbn_home);
        homeClick(null);
    }
    //返回键-功能
    /*private void setShowModel() {
        main_fragment_rgp = (RadioGroup) findViewById(R.id.main_fragment_rgp);
        Intent intent = getIntent();
        try{
            if (intent.getStringExtra("back").equals("订单")){//订单界面返回键
                main_fragment_rgp.check(R.id.main_rbn_home);//订单界面为默认显示
                orderClick(null);
            }else if (intent.getStringExtra("back").equals("我的")){
                main_fragment_rgp.check(R.id.main_rbn_my);//订单界面为默认显示
                myClick(null);
            }
        }catch (NullPointerException e){
            main_fragment_rgp.check(R.id.main_rbn_dingdan);//订单界面为默认显示
            homeClick(null);
        }
    }*/
    //首页
    public void homeClick(View v) {
        getFragmentManager().beginTransaction()
                .hide(fragments[0]).hide(fragments[2])
                .show(fragments[1]).commit();
    }
    //订单
    public void orderClick(View v) {
        getFragmentManager().beginTransaction()
                .hide(fragments[0]).hide(fragments[1])
                .show(fragments[2]).commit();
    }
    //我的
    public void myClick(View v) {
        getFragmentManager().beginTransaction()
                .hide(fragments[1]).hide(fragments[2])
                .show(fragments[0]).commit();
    }
}
















