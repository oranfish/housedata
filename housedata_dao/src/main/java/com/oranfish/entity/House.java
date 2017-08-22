package com.oranfish.entity;

import java.math.BigDecimal;
import java.util.Date;

public class House {
    private Long id;
    private Date date;
    private String title;
    private BigDecimal totalPrice;
    private BigDecimal unitPrice;
    private String houseDetail;
    private String communityDetail;
    private String label;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getHouseDetail() {
        return houseDetail;
    }

    public void setHouseDetail(String houseDetail) {
        this.houseDetail = houseDetail;
    }

    public String getCommunityDetail() {
        return communityDetail;
    }

    public void setCommunityDetail(String communityDetail) {
        this.communityDetail = communityDetail;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", date=" + date +
                ", title='" + title + '\'' +
                ", totalPrice=" + totalPrice +
                ", unitPrice=" + unitPrice +
                ", houseDetail='" + houseDetail + '\'' +
                ", communityDetail='" + communityDetail + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
