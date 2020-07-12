package com.mzl.pojo;

/**
 * @ClassName :   News
 * @Description: 财务新闻
 * @Author: 21989
 * @CreateDate: 2020/6/5 17:03
 * @Version: 1.0
 */
public class News {

    private int nid;//新闻编号
    private String nTitle;//文章标题
    private String author;//作者
    private String keyword;//关键词
    private int visitCount;//浏览次数
    private String recordTime;//记录日期
    private String nContent;//文章内容[文件路径]

    public void setNid(int nid) {
        this.nid = nid;
    }

    public void setnTitle(String nTitle) {
        this.nTitle = nTitle;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public void setnContent(String nContent) {
        this.nContent = nContent;
    }

    public int getNid() {
        return nid;
    }

    public String getnTitle() {
        return nTitle;
    }

    public String getAuthor() {
        return author;
    }

    public String getKeyword() {
        return keyword;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public String getnContent() {
        return nContent;
    }

    @Override
    public String toString() {
        return "News{" +
                "nid=" + nid +
                ", nTitle='" + nTitle + '\'' +
                ", author='" + author + '\'' +
                ", keyword='" + keyword + '\'' +
                ", visitCount=" + visitCount +
                ", recordTime='" + recordTime + '\'' +
                ", nContent='" + nContent + '\'' +
                '}';
    }
}
