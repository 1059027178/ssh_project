package com.qianyang.ayio2o.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.qianyang.ayio2o.R;
import com.qianyang.ayio2o.Test.TestOrder;
import com.qianyang.ayio2o.adapter.AdapterMyOrder;
import com.qianyang.ayio2o.model.MyOrder;

import java.util.List;
/**
 * Created by YangYang on 2016/1/21.
 */
public class OrderListActivity extends Activity implements OnClickListener, OnItemClickListener {
    private TextView title_heard;//标题
    private ImageButton imageButton_back;//返回键
    private ListView listView;
    private AdapterMyOrder adapterMyOrder;
    private String flag = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_order_list_layout);
        flag = null;
        try {
            Intent intent = getIntent();
            flag = intent.getStringExtra("flag").trim();
            Log.d("TAG", "++++flag : " + flag);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        initAll();//初始化控件
        setData(flag);//显示数据
    }

    //初始化所有控件
    private void initAll() {
        listView = (ListView) findViewById(R.id.listview_orderlist);
        title_heard = (TextView) findViewById(R.id.orderList_title_heard);
        imageButton_back = (ImageButton) findViewById(R.id.imageButton_back);
        imageButton_back.setOnClickListener(this);
        listView.setOnItemClickListener(this);
    }
    //显示数据
    private void setData(String flag) {
        if (flag.equals("今日未完成订单")) {
            title_heard.setText("今日订单-未完成");
            List<MyOrder> list = new TestOrder().getMyOrderList();
            adapterMyOrder = new AdapterMyOrder(OrderListActivity.this, R.layout.myorderfinish_listview, list);
            listView.setAdapter(adapterMyOrder);

        } else if (flag.equals("今日所有订单")) {
            title_heard.setText("今日订单-全部");

        } else if (flag.equals("今日已完成订单")) {
            title_heard.setText("今日订单-已完成");

        } else if (flag.equals("历史所有订单")) {
            title_heard.setText("历史订单-全部");

        } else if (flag.equals("历史未完成订单")) {
            title_heard.setText("历史订单-未完成");

        } else if (flag.equals("历史已完成订单")) {
            title_heard.setText("历史订单-已完成");
        }
    }

    //点击返回-返回上级
    private void setEvent() {
        Intent intent = new Intent();
        intent.putExtra("back", "订单");
        intent.setClass(OrderListActivity.this, MainActivity.class);
        this.startActivity(intent);
        OrderListActivity.this.finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            setEvent();
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
     public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton_back://返回键监听
                setEvent();
                break;
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView orderID = (TextView) view.findViewById(R.id.tv_dingDanID);
        String strOrderID = orderID.getText().toString().trim();
        Intent intent = new Intent();
        intent.putExtra("orderID",strOrderID);
        intent.putExtra("flag",flag);
        intent.setClass(OrderListActivity.this, OrderListShowMoreActivity.class);
        OrderListActivity.this.startActivity(intent);
        OrderListActivity.this.finish();
    }
}
