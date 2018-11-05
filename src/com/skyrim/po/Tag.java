package com.skyrim.po;

public class Tag {
    private Integer tid;

    private Integer vid;

    private String tagtext;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public String getTagtext() {
        return tagtext;
    }

    public void setTagtext(String tagtext) {
        this.tagtext = tagtext == null ? null : tagtext.trim();
    }
}