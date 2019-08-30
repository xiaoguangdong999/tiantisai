package top.axbt.pta.domain;

import java.util.Date;

public class TbInfo {
    private Integer id;

    private String num;

    private String name;

    private Integer l01;

    private Integer l02;

    private Integer l03;

    private String imgurl;

    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getL01() {
        return l01;
    }

    public void setL01(Integer l01) {
        this.l01 = l01;
    }

    public Integer getL02() {
        return l02;
    }

    public void setL02(Integer l02) {
        this.l02 = l02;
    }

    public Integer getL03() {
        return l03;
    }

    public void setL03(Integer l03) {
        this.l03 = l03;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TbInfo other = (TbInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getL01() == null ? other.getL01() == null : this.getL01().equals(other.getL01()))
            && (this.getL02() == null ? other.getL02() == null : this.getL02().equals(other.getL02()))
            && (this.getL03() == null ? other.getL03() == null : this.getL03().equals(other.getL03()))
            && (this.getImgurl() == null ? other.getImgurl() == null : this.getImgurl().equals(other.getImgurl()))
            && (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getL01() == null) ? 0 : getL01().hashCode());
        result = prime * result + ((getL02() == null) ? 0 : getL02().hashCode());
        result = prime * result + ((getL03() == null) ? 0 : getL03().hashCode());
        result = prime * result + ((getImgurl() == null) ? 0 : getImgurl().hashCode());
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
        return result;
    }
}