package com.apiit.eeashopping.Model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Promotion {


    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "promo_id")
    private String promoid;

    private double percentage;
    private int duration;
    private String promoName;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date startDate;

    private Date endDate = handleEndDate();



    public String getPromoid() {
        return promoid;
    }

    public void setPromoid(String promoid) {
        this.promoid = promoid;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getPromoname() {
        return promoName;
    }

    public void setPromoname(String promoname) {
        this.promoName = promoname;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startedat) {
        this.startDate = startedat;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndedate(Date endedat) {
        this.endDate = endedat;
    }

    Date handleEndDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, duration);
        return cal.getTime();
    }
}
