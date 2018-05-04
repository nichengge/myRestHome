package com.wuhongyu.entity;

import java.math.BigDecimal;

public class Lelve {
    private Integer id;

    private String lelve;

    private BigDecimal price;

    private String remarks;

    private Integer oldid;

    private String oldmanname;

    public String getOldmanname() {
        return oldmanname;
    }

    public void setOldmanname(String oldmanname) {
        this.oldmanname = oldmanname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLelve() {
        return lelve;
    }

    public void setLelve(String lelve) {
        this.lelve = lelve == null ? null : lelve.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Integer getOldid() {
        return oldid;
    }

    public void setOldid(Integer oldid) {
        this.oldid = oldid;
    }
}