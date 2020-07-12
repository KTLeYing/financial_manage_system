package com.mzl.pojo;

/**
 * @ClassName :   MonthAnalysis
 * @Description: 月分析实体类
 * @Author: 21989
 * @CreateDate: 2020/7/5 11:57
 * @Version: 1.0
 */
public class MonthAnalysis {

    private int incomeRecordCount;  //收入记录数
    private int spendsRecordCount;  //支出记录数
    private int incomeMoney;  //收入金额
    private int spendsMoney; //支出金额
    private int allMoney;   //总金额

    public void setIncomeRecordCount(int incomeRecordCount) {
        this.incomeRecordCount = incomeRecordCount;
    }

    public void setSpendsRecordCount(int spendsRecordCount) {
        this.spendsRecordCount = spendsRecordCount;
    }

    public void setSpendsMoney(int spendsMoney) {
        this.spendsMoney = spendsMoney;
    }

    public void setIncomeMoney(int incomeMoney) {
        this.incomeMoney = incomeMoney;
    }


    public void setAllMoney(int allMoney) {
        this.allMoney = allMoney;
    }

    public int getIncomeRecordCount() {
        return incomeRecordCount;
    }

    public int getSpendsRecordCount() {
        return spendsRecordCount;
    }

    public int getSpendsMoney() {
        return spendsMoney;
    }

    public int getIncomeMoney() {
        return incomeMoney;
    }

    public int getAllMoney() {
        return allMoney;
    }

    @Override
    public String toString() {
        return "MonthAnalysis{" +
                "incomeRecordCount=" + incomeRecordCount +
                ", spendsRecordCount=" + spendsRecordCount +
                ", incomeMoney=" + incomeMoney +
                ", spensdMoney=" + spendsMoney +
                ", allMoney=" + allMoney +
                '}';
    }
}
