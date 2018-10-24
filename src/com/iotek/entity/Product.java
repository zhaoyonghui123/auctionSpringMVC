package com.iotek.entity;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class Product {
    private int productid;
    private String productname;
    private String pdescribe;
    private String starttime;
    private String endtime;
    private BigDecimal startprice;
    private BigDecimal pfloorprice;
    private String pimg;

    @Override
    public String toString() {
        return "Product{" +
                "productid=" + productid +
                ", productname='" + productname + '\'' +
                ", pdescribe='" + pdescribe + '\'' +
                ", starttime='" + starttime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", startprice=" + startprice +
                ", pfloorprice=" + pfloorprice +
                ", pimg='" + pimg + '\'' +
                '}';
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getPdescribe() {
        return pdescribe;
    }

    public void setPdescribe(String pdescribe) {
        this.pdescribe = pdescribe;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public BigDecimal getStartprice() {
        return startprice;
    }

    public void setStartprice(BigDecimal startprice) {
        this.startprice = startprice;
    }

    public BigDecimal getPfloorprice() {
        return pfloorprice;
    }

    public void setPfloorprice(BigDecimal pfloorprice) {
        this.pfloorprice = pfloorprice;
    }

    public String getPimg() {
        return pimg;
    }

    public void setPimg(String pimg) {
        this.pimg = pimg;
    }
}