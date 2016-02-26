package com.qianyang.ayio2o.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qianyang.ayio2o.R;

/**
 * Created by YangYang on 2016/2/24.
 */
public class FragmentOrder_2 extends Fragment {
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_order_2, container, false);
        return view;
    }
}
