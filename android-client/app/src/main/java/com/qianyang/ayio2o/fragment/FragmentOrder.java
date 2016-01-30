package com.qianyang.ayio2o.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;

import com.qianyang.ayio2o.R;
import com.qianyang.ayio2o.activity.OrderListActivity;

/**
 * Created by YangYang on 2016/1/14.
 */
public class FragmentOrder extends Fragment implements OnClickListener {
    private TableRow tr_newDayAll;//今日所有订单
    private TableRow tr_liShiDingDan;//历史所有订单
    private TableRow tr_dingDanTongJi;//订单统计
    private TableRow tr_keHuGuanLi;//客户管理
    private TableRow tr_keHuPingJia;//客户评价
    private TextView tv_liShiAllCount;//历史所有订单统计
    private TextView tv_newDayAllCount;//今日所有订单统计
    private TextView tv_newDayWanCheng;//今日未完成订单
    private TextView tv_newDayYiWanCheng;//今日已完成订单
    private TextView tv_liShiWeiWanCheng;//历史未完成订单
    private TextView tv_liShiYiWanCheng;//历史已完成订单
    private Activity activity;
    private Intent intent;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        this.activity = getActivity();
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        initAll();//初始化所有控件
        setAllCount();//设置所有的计数
        addClickEvent();//监听事件
        super.onActivityCreated(savedInstanceState);
    }
//设置所有的计数
    private void setAllCount() {
    }
    //初始化所有控件
    private void initAll() {
        tv_liShiAllCount  = (TextView) activity.findViewById(R.id.tv_liShiAllCount);
        tv_newDayAllCount = (TextView) activity.findViewById(R.id.tv_newDayAllCount);
        tv_newDayWanCheng  = (TextView) activity.findViewById(R.id.tv_newDayWanCheng);
        tv_newDayYiWanCheng= (TextView) activity.findViewById(R.id.tv_newDayYiWanCheng);
        tv_liShiWeiWanCheng= (TextView) activity.findViewById(R.id.tv_liShiWeiWanCheng);
        tv_liShiYiWanCheng = (TextView) activity.findViewById(R.id.tv_liShiYiWanCheng);

        tr_newDayAll      = (TableRow) activity.findViewById(R.id.tr_newDayAll);
        tr_liShiDingDan   = (TableRow) activity.findViewById(R.id.tr_liShiDingDan);
        tr_dingDanTongJi  = (TableRow) activity.findViewById(R.id.tr_dingDanTongJi);
        tr_keHuGuanLi     = (TableRow) activity.findViewById(R.id.tr_keHuGuanLi);
        tr_keHuPingJia    = (TableRow) activity.findViewById(R.id.tr_keHuPingJia);
    }
//监听事件
    private void addClickEvent() {
        tr_newDayAll.setOnClickListener(this);
        tr_liShiDingDan.setOnClickListener(this);
        tr_dingDanTongJi.setOnClickListener(this);
        tr_keHuGuanLi.setOnClickListener(this);
        tr_keHuPingJia.setOnClickListener(this);
        tv_newDayWanCheng.setOnClickListener(this);
        tv_newDayYiWanCheng.setOnClickListener(this);
        tv_liShiWeiWanCheng.setOnClickListener(this);
        tv_liShiYiWanCheng.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tr_newDayAll://今日所有订单

                break;
            case R.id.tv_newDayWanCheng://今日未完成订单
                intent = new Intent();
                intent.putExtra("flag","今日未完成订单");
                intent.setClass(activity, OrderListActivity.class);
                activity.startActivity(intent);
                activity.finish();
                break;
            case R.id.tv_newDayYiWanCheng://今日已完成订单

                break;
            case R.id.tr_liShiDingDan://所有订单
                break;
            case R.id.tr_dingDanTongJi://订单统计
                break;
            case R.id.tr_keHuGuanLi://客户管理
                break;
            case R.id.tr_keHuPingJia://客户评价
                break;
        }
    }
}
