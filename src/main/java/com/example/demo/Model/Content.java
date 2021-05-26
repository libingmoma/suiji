package com.example.demo.Model;


import com.alibaba.fastjson.annotation.JSONType;
import com.example.demo.Base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "`content`")
@JSONType(orders = {"cid","ctype","rtime", "cdescription", "picuri"})
public class Content extends BaseEntity {

    @Column(name = "`cid`")
    private long cid;

    @Column(name = "`ctype`")
    private int ctype;


    @Column(name = "`rtime`")
    private String rtime;


    @Column(name = "`cdescription`")

    private String cdescription;


    @Column(name = "`picuri`")
    private String picuri;

    public Content(long cid, int ctype, String cdescription, String picuri, String rtime) {
        this.cid = cid;
        this.ctype = ctype;
        this.cdescription = cdescription;
        this.picuri = picuri;
        this.rtime = rtime;
    }

    public Content() {

    }

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    public int getCtype() {
        return ctype;
    }

    public void setCtype(int ctype) {
        this.ctype = ctype;
    }

    public String getCdescription() {
        return cdescription;
    }

    public void setCdescription(String cdescription) {
        this.cdescription = cdescription;
    }

    public String getRtime() {
        return rtime;
    }

    public void setRtime(String rtime) {
        this.rtime = rtime;
    }

    public String getPicuri() {
        return picuri;
    }

    public void setPicuri(String picuri) {
        this.picuri = picuri;
    }
}