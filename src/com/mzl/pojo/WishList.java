package com.mzl.pojo;

/**
 * @ClassName :   WishList
 * @Description: 心愿单
 * @Author: 21989
 * @CreateDate: 2020/7/6 12:52
 * @Version: 1.0
 */
public class WishList {

    private int id; //主键
    private String wid; //心愿编号
    private String wish; //心愿说明
    private int wnum;  //心愿目标金额
    private String wdate; //心愿记录日期
    private String state; //心愿完成状态
    private int user_id;  //用户id

    public void setId(int id) {
        this.id = id;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public void setWnum(int wnum) {
        this.wnum = wnum;
    }

    public void setWdate(String wdate) {
        this.wdate = wdate;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public String getWid() {
        return wid;
    }

    public String getWish() {
        return wish;
    }

    public int getWnum() {
        return wnum;
    }

    public String getWdate() {
        return wdate;
    }

    public String getState() {
        return state;
    }

    public int getUser_id() {
        return user_id;
    }

    @Override
    public String toString() {
        return "WishList{" +
                "id=" + id +
                ", wid='" + wid + '\'' +
                ", wish='" + wish + '\'' +
                ", wnum=" + wnum +
                ", wdate='" + wdate + '\'' +
                ", state='" + state + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
