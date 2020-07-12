package com.mzl.pojo;

/**
 * @ClassName :   Budget
 * @Description: 预算
 * @Author: 21989
 * @CreateDate: 2020/7/5 21:11
 * @Version: 1.0
 */
public class Budget {

    private int wid;   //预算id
    private String wtime;  //预算所在月份
    private int wnum;  //预算金额
    private int user_id;  //所属用户

    public void setWid(int wid) {
        this.wid = wid;
    }

    public void setWtime(String wtime) {
        this.wtime = wtime;
    }

    public void setWnum(int wnum) {
        this.wnum = wnum;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getWid() {
        return wid;
    }

    public String getWtime() {
        return wtime;
    }

    public int getWnum() {
        return wnum;
    }

    public int getUser_id() {
        return user_id;
    }

    @Override
    public String toString() {
        return "Budget{" +
                "wid=" + wid +
                ", wtime='" + wtime + '\'' +
                ", wnum=" + wnum +
                ", user_id=" + user_id +
                '}';
    }
}
