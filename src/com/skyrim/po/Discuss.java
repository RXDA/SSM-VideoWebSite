package com.skyrim.po;

public class Discuss {
    private Integer did;

    private Integer uid;

    private Integer vid;

    private String discusstext;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public String getDiscusstext() {
        return discusstext;
    }

    public void setDiscusstext(String discusstext) {
        this.discusstext = discusstext == null ? null : discusstext.trim();
    }
}