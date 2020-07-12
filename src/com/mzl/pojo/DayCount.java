package com.mzl.pojo;

/**
 * @ClassName :   DayCount
 * @Description: 绘制表图时需要，返回封装好的json的Javabean对象
 * @Author: 21989
 * @CreateDate: 2020/7/4 18:48
 * @Version: 1.0
 */
public class DayCount {

    private int dayName;  //某天：日
    private int moneyName;  //每天的金额
    private String categoryName; //收支子类型

    public void setDayName(int dayName) {
        this.dayName = dayName;
    }

    public void setMoneyName(int moneyName) {
        this.moneyName = moneyName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getDayName() {
        return dayName;
    }

    public int getMoneyName() {
        return moneyName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public String toString() {
        return "DayCount{" +
                "dayName=" + dayName +
                ", moneyName=" + moneyName +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
