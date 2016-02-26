package com.qianyang.ayio2o.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qianyang.ayio2o.R;
/**
 * Created by YangYang on 2016/1/14.
 */
public class FragmentMy extends Fragment {
    private Activity activity;
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
        /*Intent intent = activity.getIntent();
        String userName = intent.getStringExtra("userName");
        String userPwd = intent.getStringExtra("userPwd");
        Log.d("TAG", "userName>>>>>>>" + userName);
        Log.d("TAG", "userPwd >>>>>>>"+userPwd);*/
        super.onActivityCreated(savedInstanceState);
    }

}
