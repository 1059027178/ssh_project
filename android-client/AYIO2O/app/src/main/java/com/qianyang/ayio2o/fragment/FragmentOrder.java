package com.qianyang.ayio2o.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianyang.ayio2o.R;
/**
 * Created by YangYang on 2016/1/14.
 */
public class FragmentOrder extends Fragment implements OnClickListener {
    private Activity activity;
    private Intent intent;
    private String userName = null;
    private ImageView img1, img2, img3, img4;
    private TextView text_v1, text_v2, text_v3, text_v4;
    private Fragment[] fragments = new Fragment[4];
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        this.activity = getActivity();
        Intent intent = activity.getIntent();
        userName = intent.getStringExtra("userName");
        String userPwd = intent.getStringExtra("userPwd");
        Log.d("TAG", "userName>>>>>>>" + userName);
        Log.d("TAG", "userPwd >>>>>>>" + userPwd);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Initview();
    }
    //初始化
    private void Initview() {
        text_v1 = (TextView) activity.findViewById(R.id.order_tv_1);
        text_v2 = (TextView) activity.findViewById(R.id.order_tv_2);
        text_v3 = (TextView) activity.findViewById(R.id.order_tv_3);
        text_v4 = (TextView) activity.findViewById(R.id.order_tv_4);
        text_v1.setOnClickListener(FragmentOrder.this);
        text_v2.setOnClickListener(FragmentOrder.this);
        text_v3.setOnClickListener(FragmentOrder.this);
        text_v4.setOnClickListener(FragmentOrder.this);
        img1 = (ImageView) activity.findViewById(R.id.order_img1);
        img2 = (ImageView) activity.findViewById(R.id.order_img2);
        img3 = (ImageView) activity.findViewById(R.id.order_img3);
        img4 = (ImageView) activity.findViewById(R.id.order_img4);
        fragments[0] = new FragmentOrder_1();
        fragments[1] = new FragmentOrder_2();
        fragments[2] = new FragmentOrder_3();
        fragments[3] = new FragmentOrder_4();
        getFragmentManager().beginTransaction()
                .add(R.id.fragmentOrder, fragments[0])
                .add(R.id.fragmentOrder, fragments[1])
                .add(R.id.fragmentOrder, fragments[2])
                .add(R.id.fragmentOrder, fragments[3]).commit();
        getFragmentManager().beginTransaction()
                .hide(fragments[1]).hide(fragments[2]).hide(fragments[3])
                .show(fragments[0]).commit();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.order_tv_1:onclickOrder1();break;
            case R.id.order_tv_2:onclickOrder2();break;
            case R.id.order_tv_3:onclickOrder3();break;
            case R.id.order_tv_4:onclickOrder4();break;
        }
    }
    private void onclickOrder4() {
        getFragmentManager().beginTransaction()
                .hide(fragments[0]).hide(fragments[2]).hide(fragments[1])
                .show(fragments[3]).commit();
        img4.setVisibility(View.VISIBLE);
        img1.setVisibility(View.INVISIBLE);
        img2.setVisibility(View.INVISIBLE);
        img3.setVisibility(View.INVISIBLE);
        text_v4.setTextColor(getResources().getColor(R.color.color1));
        text_v2.setTextColor(getResources().getColor(R.color.colorBlack));
        text_v3.setTextColor(getResources().getColor(R.color.colorBlack));
        text_v1.setTextColor(getResources().getColor(R.color.colorBlack));
    }
    private void onclickOrder3() {
        getFragmentManager().beginTransaction()
                .hide(fragments[0]).hide(fragments[1]).hide(fragments[3])
                .show(fragments[2]).commit();
        img3.setVisibility(View.VISIBLE);
        img1.setVisibility(View.INVISIBLE);
        img2.setVisibility(View.INVISIBLE);
        img4.setVisibility(View.INVISIBLE);
        text_v3.setTextColor(getResources().getColor(R.color.color1));
        text_v2.setTextColor(getResources().getColor(R.color.colorBlack));
        text_v1.setTextColor(getResources().getColor(R.color.colorBlack));
        text_v4.setTextColor(getResources().getColor(R.color.colorBlack));
    }
    private void onclickOrder2() {
        getFragmentManager().beginTransaction()
                .hide(fragments[2]).hide(fragments[3]).hide(fragments[0])
                .show(fragments[1]).commit();
        img2.setVisibility(View.VISIBLE);
        img1.setVisibility(View.INVISIBLE);
        img3.setVisibility(View.INVISIBLE);
        img4.setVisibility(View.INVISIBLE);
        text_v2.setTextColor(getResources().getColor(R.color.color1));
        text_v1.setTextColor(getResources().getColor(R.color.colorBlack));
        text_v3.setTextColor(getResources().getColor(R.color.colorBlack));
        text_v4.setTextColor(getResources().getColor(R.color.colorBlack));
    }
    private void onclickOrder1() {
        getFragmentManager().beginTransaction()
                .hide(fragments[1]).hide(fragments[2]).hide(fragments[3])
                .show(fragments[0]).commit();
        img1.setVisibility(View.VISIBLE);
        img2.setVisibility(View.INVISIBLE);
        img3.setVisibility(View.INVISIBLE);
        img4.setVisibility(View.INVISIBLE);
        text_v1.setTextColor(getResources().getColor(R.color.color1));
        text_v2.setTextColor(getResources().getColor(R.color.colorBlack));
        text_v3.setTextColor(getResources().getColor(R.color.colorBlack));
        text_v4.setTextColor(getResources().getColor(R.color.colorBlack));
    }
}
