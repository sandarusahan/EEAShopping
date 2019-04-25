package com.apiit.eeashopping.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String pId;

    private String pName;
    @Column(name = "p_category")
    private String categoryId;
    private String pDescription;
    private double pPrice;
    private int pQty;
    @Column(name = "p_promotion")
    private String promotionId;


    private String pImg;

    private boolean isActive;

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public double getpPrice() {
        return pPrice;
    }

    public void setpPrice(double pPrice) {
        this.pPrice = pPrice;
    }

    public int getpQty() {
        return pQty;
    }

    public void setpQty(int pQty) {
        this.pQty = pQty;
    }


    public String getpImg() {
        return pImg;
    }

    public void setpImg(String pImg) {
        this.pImg = pImg;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(String  promotionId) {
        this.promotionId = promotionId;
    }
}
