package com.skyrim.custompo;

public class PrivateLetterAndUser {
	private Integer pid;

	private Integer senderuid;

    private Integer receiveruid;

    private String message;

    private Boolean isread;
    
    private String nickname;
    
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
		this.message = message;
	}

	public Boolean getIsread() {
		return isread;
	}

	public void setIsread(Boolean isread) {
		this.isread = isread;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
