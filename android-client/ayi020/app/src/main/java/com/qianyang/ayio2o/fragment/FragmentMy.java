package com.qianyang.ayio2o.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qianyang.ayio2o.R;
/**
 * Created by YangYang on 2016/1/14.
 */
public class FragmentMy extends Fragment implements OnClickListener {
    private Activity activity;
    private ImageView iv_heard;//头像
    private TextView tv_geRenXinXi;//个人信息
    private TextView tv_chaXunMingXi;//查询明细
    private TextView tv_yuETiXian;//余额提现
    private TextView tv_zhagHuChongZhi;//账户充值
    private LinearLayout lv_yinHangKaGuanLi;//银行卡管理
    private LinearLayout lv_riChengGuanLi;//日程管理
    private LinearLayout lv_gengDuo;//日程管理
    private LinearLayout lv_TuiChu;//退出登录
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        this.activity = getActivity();
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        initAll();//初始化所有控件
        addClickEvent();//监听事件
        super.onActivityCreated(savedInstanceState);
    }
    //初始化所有控件
    private void initAll() {
        iv_heard = (ImageView) activity.findViewById(R.id.iv_heard);
        tv_geRenXinXi    = (TextView) activity.findViewById(R.id.tv_geRenXinXi);
        tv_chaXunMingXi  = (TextView) activity.findViewById(R.id.tv_chaXunMingXi);
        tv_yuETiXian     = (TextView) activity.findViewById(R.id.tv_yuETiXian);
        tv_zhagHuChongZhi= (TextView) activity.findViewById(R.id.tv_zhagHuChongZhi);
        lv_yinHangKaGuanLi= (LinearLayout) activity.findViewById(R.id.lv_yinHangKaGuanLi);
        lv_riChengGuanLi  = (LinearLayout) activity.findViewById(R.id.lv_riChengGuanLi);
        lv_gengDuo        = (LinearLayout) activity.findViewById(R.id.lv_gengDuo);
        lv_TuiChu         = (LinearLayout) activity.findViewById(R.id.lv_TuiChu);
    }
//监听事件
    private void addClickEvent() {
        iv_heard.setOnClickListener(this);
        tv_geRenXinXi.setOnClickListener(this);
        tv_chaXunMingXi.setOnClickListener(this);
        tv_yuETiXian.setOnClickListener(this);
        tv_zhagHuChongZhi.setOnClickListener(this);
        lv_yinHangKaGuanLi.setOnClickListener(this);
        lv_riChengGuanLi.setOnClickListener(this);
        lv_gengDuo.setOnClickListener(this);
        lv_TuiChu.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_heard://点击头像
                break;
            case R.id.tv_geRenXinXi://点击姓名查看个人信息
                break;
            case R.id.tv_chaXunMingXi://点击查询明细
                break;
            case R.id.tv_yuETiXian://余额提现
                break;
            case R.id.tv_zhagHuChongZhi://账户充值
                break;
            case R.id.lv_yinHangKaGuanLi://银行卡管理
                break;
            case R.id.lv_riChengGuanLi://日程管理
                break;
            case R.id.lv_gengDuo://更多设置
                break;
            case R.id.lv_TuiChu://退出登陆
                break;
        }
    }
}
