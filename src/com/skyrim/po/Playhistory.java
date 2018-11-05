package com.skyrim.po;

import java.util.Date;

public class Playhistory {
    private Integer hid;

    private Integer vid;

    private Integer uid;

    private Date playdate;

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getPlaydate() {
        return playdate;
    }

    public void setPlaydate(Date playdate) {
        this.playdate = playdate;
    }
}