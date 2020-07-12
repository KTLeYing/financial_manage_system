package com.mzl.service;

import com.mzl.pojo.News;
import com.mzl.pojo.PageBean;

import java.util.List;

/**
 * @InterfaceName :   NewsService
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/18 17:19
 * @Version: 1.0
 */
public interface NewsService {

    //查出8条财务新闻，通过录入时间 和  访问量的多少来决定显示
    List<News> findNewsEightList();

    //分页查询新闻列表
    PageBean<News> findNewsList2(News news, Integer currentPage);

    //通过id查询当前新闻信息
    News queryNewsById(Integer nid);

    //访问一次新闻，阅读量加1
    void addVisitCount(Integer nid);

    //分页查询新闻列表
    PageBean<News> findNewsList(News news, Integer currentPage);

    //查询新闻的文件路径
    News findNewsContnet(int nid);

    //编辑修改数据库中的新闻
    void editNews(News news);

    //添加新闻到数据库
    void addNews(News news);

    //删除新闻
    void deleteNews(int nid);

    //就新闻总记录数
    int findNewsCount(News news);
}
