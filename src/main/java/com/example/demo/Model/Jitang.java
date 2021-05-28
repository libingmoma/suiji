package com.example.demo.Model;

import com.example.demo.Base.BaseEntity;

import javax.persistence.Column;

import javax.persistence.Table;

@Table(name = "`jitang`")
public class Jitang extends BaseEntity {
    @Column(name = "‘jid’")
    private long jid;

    @Column(name = "’content‘")
    private String content;

    public Jitang(long jid, String content) {
        this.jid = jid;
        this.content = content;
    }

    public Jitang() {
    }

    public long getJid() {
        return jid;
    }

    public void setJid(long jid) {
        this.jid = jid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {this.content = content;}

}
