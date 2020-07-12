package com.mzl.pojo;

/**
 * @ClassName :   Memorandum
 * @Description: 备忘录
 * @Author: 21989
 * @CreateDate: 2020/7/6 17:47
 * @Version: 1.0
 */
public class Memorandum {

    private int mid; //id
    private String recordTime; //记录时间
    private String thingPath;  //文件路径
    private String topFont;  //文件内容前83个字
    private int user_id;  //所属用户

    public void setMid(int mid) {
        this.mid = mid;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public void setThingPath(String thingPath) {
        this.thingPath = thingPath;
    }

    public void setTopFont(String topFont) {
        this.topFont = topFont;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getMid() {
        return mid;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public String getThingPath() {
        return thingPath;
    }

    public String getTopFont() {
        return topFont;
    }

    public int getUser_id() {
        return user_id;
    }

    @Override
    public String toString() {
        return "Memorandum{" +
                "mid=" + mid +
                ", recordTime='" + recordTime + '\'' +
                ", thingPath='" + thingPath + '\'' +
                ", topFont='" + topFont + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
