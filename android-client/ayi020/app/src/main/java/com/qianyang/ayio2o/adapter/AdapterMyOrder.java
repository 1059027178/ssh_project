package com.qianyang.ayio2o.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qianyang.ayio2o.R;
import com.qianyang.ayio2o.model.MyOrder;

import java.util.List;
/**
 * Created by YangYang on 2016/1/15.
 */
public class AdapterMyOrder extends ArrayAdapter<MyOrder> {
    private int resourceId;
    private TextView tv_dingDan_xq;//详情
    public AdapterMyOrder(Context context, int resource, List<MyOrder> objects) {
        super(context, resource, objects);
        this.resourceId = resource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyOrder myOrder = (MyOrder) getItem(position);
        LinearLayout linearLayout = new LinearLayout(getContext());
        String inflater = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater vi = (LayoutInflater) getContext().getSystemService(inflater);
        vi.inflate(resourceId, linearLayout, true);
        //文字加载
        ((TextView)linearLayout.findViewById(R.id.tv_dingDanID))  .setText(myOrder.getDingDanID());
        ((TextView)linearLayout.findViewById(R.id.tv_buyerZT))    .setText(myOrder.getBuyerZT());
        ((TextView)linearLayout.findViewById(R.id.tv_dingDanDate)).setText(myOrder.getDingDanDate());
        ((TextView)linearLayout.findViewById(R.id.tv_fuWuLeiBie)) .setText(myOrder.getFuWuLX());
        ((TextView)linearLayout.findViewById(R.id.tv_fuwuDiZhi))  .setText(myOrder.getFuWUDiZhi());
        ((TextView)linearLayout.findViewById(R.id.tv_dingDanZT))  .setText(myOrder.getDingDanZT());
        return linearLayout;
    }
}
