package com.skyrim.po;

import java.util.Date;

public class Privateletter {
    private Integer pid;

    private Integer senderuid;

    private Integer receiveruid;

    private String message;

    private Boolean isread;

    private Date senddate;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getSenderuid() {
        return senderuid;
    }

    public void setSenderuid(Integer senderuid) {
        this.senderuid = senderuid;
    }

    public Integer getReceiveruid() {
        return receiveruid;
    }

    public void setReceiveruid(Integer receiveruid) {
        this.receiveruid = receiveruid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Boolean getIsread() {
        return isread;
    }

    public void setIsread(Boolean isread) {
        this.isread = isread;
    }

    public Date getSenddate() {
        return senddate;
    }

    public void setSenddate(Date senddate) {
        this.senddate = senddate;
    }
}