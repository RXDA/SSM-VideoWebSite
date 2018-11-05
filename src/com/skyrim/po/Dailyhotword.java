package com.skyrim.po;

public class Dailyhotword {
    private Integer hotwordid;

    private String hotword;

    private Integer times;

    public Integer getHotwordid() {
        return hotwordid;
    }

    public void setHotwordid(Integer hotwordid) {
        this.hotwordid = hotwordid;
    }

    public String getHotword() {
        return hotword;
    }

    public void setHotword(String hotword) {
        this.hotword = hotword == null ? null : hotword.trim();
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }
}