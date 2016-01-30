package com.qianyang.ayio2o.Test;

import com.qianyang.ayio2o.model.MyOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YangYang on 2016/1/15.
 */
public class TestOrder {
    /**
     *
     * @return MyOrder list列表
     */
    public List<MyOrder> getMyOrderList(){
        List<MyOrder> list = new ArrayList<MyOrder>();

        MyOrder myOrder = new MyOrder();
        myOrder.setDingDanID("00");
        myOrder.setBuyerZT("已接单");
        myOrder.setDingDanDate("2015-04-06 15:30");
        myOrder.setDingDanZT("未完成服务");
        myOrder.setFuWUDiZhi("四川省广元市利州区四川信息职业技术学院雪峰校区俊院4306");
        myOrder.setFuWuLX("寝室大扫除");
//        myOrder.setSellerZT("未结单");

        MyOrder myOrder1 = new MyOrder();
        myOrder1.setDingDanID("01");
        myOrder1.setBuyerZT("已接单");
        myOrder1.setDingDanDate("2015-04-06 15:40");
        myOrder1.setDingDanZT("未完成服务");
        myOrder1.setFuWUDiZhi("四川省广元市利州区四川信息职业技术学院雪峰校区俊院4306");
        myOrder1.setFuWuLX("寝室大扫除");
//        myOrder1.setSellerZT("已结单");

        MyOrder myOrder2 = new MyOrder();
        myOrder2.setDingDanID("02");
        myOrder2.setBuyerZT("已接单");
        myOrder2.setDingDanDate("2015-04-06 15:00");
        myOrder2.setDingDanZT("未完成服务");
        myOrder2.setFuWUDiZhi("四川省广元市利州区川北幼专秀院2306");
        myOrder2.setFuWuLX("寝室大扫除");
//        myOrder2.setSellerZT("已结单");

        MyOrder myOrder3 = new MyOrder();
        myOrder3.setDingDanID("03");
        myOrder3.setBuyerZT("已接单");
        myOrder3.setDingDanDate("2015-04-06 15:00");
        myOrder3.setDingDanZT("未完成服务");
        myOrder3.setFuWUDiZhi("四川省广元市利州区四川信息职业技术学院雪峰校区秀院2306");
        myOrder3.setFuWuLX("寝室大扫除");
//        myOrder3.setSellerZT("已结单");

        MyOrder myOrder4 = new MyOrder();
        myOrder4.setDingDanID("04");
        myOrder4.setBuyerZT("已接单");
        myOrder4.setDingDanDate("2015-04-06 15:00");
        myOrder4.setDingDanZT("未完成服务");
        myOrder4.setFuWUDiZhi("四川省广元市利州区川北幼专秀院2306");
        myOrder4.setFuWuLX("寝室大扫除");
//        myOrder4.setSellerZT("已结单");

        MyOrder myOrder5 = new MyOrder();
        myOrder5.setDingDanID("05");
        myOrder5.setBuyerZT("已接单");
        myOrder5.setDingDanDate("2015-04-06 15:00");
        myOrder5.setDingDanZT("未完成服务");
        myOrder5.setFuWUDiZhi("四川省广元市利州区四川信息职业技术学院雪峰校区秀院2306");
        myOrder5.setFuWuLX("寝室大扫除");
//        myOrder5.setSellerZT("已结单");

        MyOrder myOrder6 = new MyOrder();
        myOrder6.setDingDanID("06");
        myOrder6.setBuyerZT("已接单");
        myOrder6.setDingDanDate("2015-04-06 15:00");
        myOrder6.setDingDanZT("未完成服务");
        myOrder6.setFuWUDiZhi("四川省广元市利州区川北幼专秀院2306");
        myOrder6.setFuWuLX("寝室大扫除");
//        myOrder6.setSellerZT("已结单");

        MyOrder myOrder7 = new MyOrder();
        myOrder7.setDingDanID("07");
        myOrder7.setBuyerZT("已接单");
        myOrder7.setDingDanDate("2015-04-06 15:00");
        myOrder7.setDingDanZT("未完成服务");
        myOrder7.setFuWUDiZhi("四川省广元市利州区四川信息职业技术学院雪峰校区秀院2306");
        myOrder7.setFuWuLX("寝室大扫除");
//        myOrder7.setSellerZT("已结单");

        list.add(myOrder);
        list.add(myOrder1);
        list.add(myOrder2);
        list.add(myOrder3);
        list.add(myOrder4);
        list.add(myOrder5);
        list.add(myOrder6);
        list.add(myOrder7);
        return list;
    }
}
