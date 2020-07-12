package com.mzl.pojo;

/**
 * @ClassName :   MonthCount
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/7/3 18:00
 * @Version: 1.0
 */
public class MonthCount {

    private int monthName;  //月份
    private int moneyName;  //金额

    //粗心大意，mysql查询之类型不匹配
    //Invalid value for getInt()是一个java.sql.SQLException异常
    //查询SQL会看到查询的字段是vachar型  ,3但是我们使用mybatis时，写的返回值接收是int型，所以转换出错了
    //private int categoryName;//类型名  --错误

    private String categoryName; //类型名

    public void setMonthName(int monthName) {
        this.monthName = monthName;
    }

    public void setMoneyName(int moneyName) {
        this.moneyName = moneyName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getMonthName() {
        return monthName;
    }

    public int getMoneyName() {
        return moneyName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public String toString() {
        return "MonthCount{" +
                "monthName=" + monthName +
                ", moneyName=" + moneyName +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }

}
