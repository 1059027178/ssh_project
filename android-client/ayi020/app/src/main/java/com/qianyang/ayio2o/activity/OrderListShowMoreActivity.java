package com.qianyang.ayio2o.activity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import com.qianyang.ayio2o.R;
/**
 * Created by YangYang on 2016/1/23.
 */
public class OrderListShowMoreActivity extends Activity implements OnClickListener {
    private TextView orderId;
    private ImageButton imageButton_back;//返回键
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_order_listmore_layout);
        String strOrderID = null;
        try{
            Intent intent = getIntent();
            strOrderID = "订单ID：" + intent.getStringExtra("orderID").toString().trim();
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        orderId = (TextView) this.findViewById(R.id.orderID);
        imageButton_back = (ImageButton) this.findViewById(R.id.imageButton_back);
        imageButton_back.setOnClickListener(this);

        orderId.setText(strOrderID);
    }

//点击返回-返回上级
    private void setEvent() {
        Intent intent = new Intent();
        intent.putExtra("flag", getIntent().getStringExtra("flag").trim());
        Log.d("TAG", "back: " + getIntent().getStringExtra("flag").trim());
        intent.setClass(OrderListShowMoreActivity.this, OrderListActivity.class);
        this.startActivity(intent);
        OrderListShowMoreActivity.this.finish();
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
//点击返回-返回上级
}
