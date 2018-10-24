package com.iotek.entity;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class Record {
    private int id;
    private int productid;
    private int userid;
    private String auctiontime;
    private BigDecimal auctionprice;
    private String username;

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", productid=" + productid +
                ", userid=" + userid +
                ", auctiontime='" + auctiontime + '\'' +
                ", auctionprice=" + auctionprice +
                ", username='" + username + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getAuctiontime() {
        return auctiontime;
    }

    public void setAuctiontime(String auctiontime) {
        this.auctiontime = auctiontime;
    }

    public BigDecimal getAuctionprice() {
        return auctionprice;
    }

    public void setAuctionprice(BigDecimal auctionprice) {
        this.auctionprice = auctionprice;
    }
}