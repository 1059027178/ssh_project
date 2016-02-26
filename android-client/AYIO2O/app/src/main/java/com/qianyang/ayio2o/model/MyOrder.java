package com.qianyang.ayio2o.model;

/**
 * Created by YangYang on 2016/1/15.
 */
public class MyOrder {

    /**
     * 订单号
     */
    private String dingDanID;
    /**
     * 买家状态（是否接单）
     */
    private String buyerZT;
    /**
     * 卖家状态（是否结单）
     */
    private String sellerZT;
    /**
     * 订单生成日期
     */
    private String dingDanDate;
    /**
     * 订单服务类型
     */
    private String fuWuLX;
    /**
     * 服务地址
     */
    private String fuWUDiZhi;
    /**
     * 订单状态（是否完成服务）
     */
    private String dingDanZT;

    public String getDingDanID() {
        return dingDanID;
    }

    public void setDingDanID(String dingDanID) {
        this.dingDanID = dingDanID;
    }

    public String getBuyerZT() {
        return buyerZT;
    }

    public void setBuyerZT(String buyerZT) {
        this.buyerZT = buyerZT;
    }

    public String getSellerZT() {
        return sellerZT;
    }

    public void setSellerZT(String sellerZT) {
        this.sellerZT = sellerZT;
    }

    public String getFuWuLX() {
        return fuWuLX;
    }

    public void setFuWuLX(String fuWuLX) {
        this.fuWuLX = fuWuLX;
    }

    public String getFuWUDiZhi() {
        return fuWUDiZhi;
    }

    public void setFuWUDiZhi(String fuWUDiZhi) {
        this.fuWUDiZhi = fuWUDiZhi;
    }

    public String getDingDanDate() {
        return dingDanDate;
    }

    public void setDingDanDate(String dingDanDate) {
        this.dingDanDate = dingDanDate;
    }

    public String getDingDanZT() {
        return dingDanZT;
    }

    public void setDingDanZT(String dingDanZT) {
        this.dingDanZT = dingDanZT;
    }
}
