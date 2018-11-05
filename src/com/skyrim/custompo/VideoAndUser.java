package com.skyrim.custompo;

import java.util.Date;

public class VideoAndUser{
    private Integer vid;

    private Integer subuid;
    
    private String upernick;

	private String vtitle;

    private String vurl;

    private Integer vplaytime;

    private Integer vcoll;

    private String vtype;

    private String vcover;

    private Date vdate;

    private Boolean isdelete;

    private String vintroduce;

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public Integer getSubuid() {
        return subuid;
    }
    
    public String getUpernick() {
		return upernick;
	}

	public void setUpernick(String upernick) {
		this.upernick = upernick;
	}

    public void setSubuid(Integer subuid) {
        this.subuid = subuid;
    }

    public String getVtitle() {
        return vtitle;
    }

    public void setVtitle(String vtitle) {
        this.vtitle = vtitle == null ? null : vtitle.trim();
    }

    public String getVurl() {
        return vurl;
    }

    public void setVurl(String vurl) {
        this.vurl = vurl == null ? null : vurl.trim();
    }

    public Integer getVplaytime() {
        return vplaytime;
    }

    public void setVplaytime(Integer vplaytime) {
        this.vplaytime = vplaytime;
    }

    public Integer getVcoll() {
        return vcoll;
    }

    public void setVcoll(Integer vcoll) {
        this.vcoll = vcoll;
    }

    public String getVtype() {
        return vtype;
    }

    public void setVtype(String vtype) {
        this.vtype = vtype == null ? null : vtype.trim();
    }

    public String getVcover() {
        return vcover;
    }

    public void setVcover(String vcover) {
        this.vcover = vcover == null ? null : vcover.trim();
    }

    public Date getVdate() {
        return vdate;
    }

    public void setVdate(Date vdate) {
        this.vdate = vdate;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }

    public String getVintroduce() {
        return vintroduce;
    }

    public void setVintroduce(String vintroduce) {
        this.vintroduce = vintroduce == null ? null : vintroduce.trim();
    }
    
    
}