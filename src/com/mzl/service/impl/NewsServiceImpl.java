package com.mzl.service.impl;

import com.mzl.mapper.NewsMapper;
import com.mzl.pojo.News;
import com.mzl.pojo.PageBean;
import com.mzl.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName :   NewsServiceImpl
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/18 17:19
 * @Version: 1.0
 */
@Transactional
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    //查出8条财务新闻，通过录入时间 和  访问量的多少来决定显示
    @Override
    public List<News> findNewsEightList() {
        return newsMapper.findNewsEightList();
    }

    //分页查询新闻列表[12条记录]
    @Override
    public PageBean<News> findNewsList2(News news, Integer currentPage) {
        //封装分页Bean
        if (currentPage == null){
            currentPage = 0;
        }

        int pageRecord = 3;
        // 查询新闻总记录数
        int allRecord = newsMapper.findNewsCount(news);

        //总页数
        int allPage = 0;
        if (allRecord % pageRecord == 0){
            allPage = allRecord / pageRecord;
        }else {
            allPage = allRecord / pageRecord + 1;
        }

        // 开始位置
        int startPosition = currentPage * pageRecord;

        // 分页查询条件
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("news", news);
        map.put("startPosition", startPosition);
        map.put("pageRecord", pageRecord);

        // 分页查询新闻当前页记录列表
        List<News> pageList = newsMapper.findNewsCurrentPageList(map);

        PageBean<News> pageBean = new PageBean<News>();
        pageBean.setAllPage(allPage);
        pageBean.setAllRecord(allRecord);
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageRecord(pageRecord);
        pageBean.setStartPosition(startPosition);
        pageBean.setPageList(pageList);

        System.out.println("allRecord：" + allRecord);
        System.out.println("currentPage:"+currentPage);
        System.out.println("pageList.size()"+pageList.size());

        return pageBean;
    }

    //通过id查询当前新闻信息
    @Override
    public News queryNewsById(Integer nid) {
        return newsMapper.queryNewsById(nid);
    }

    //访问一次新闻，阅读量加1
    @Override
    public void addVisitCount(Integer nid) {
        newsMapper.addVisitCount(nid);
    }

    //分页查询新闻列表
    @Override
    public PageBean<News> findNewsList(News news, Integer currentPage) {
        System.out.println(news);
        System.out.println(currentPage);

        //当currentPage为空设置为0
        if (currentPage == null){
            currentPage = 0;
        }

        //每页记录数
        int pageRecord = 10;

        //总记录数
        int allRecord = newsMapper.findNewsCount(news);
        System.out.println(allRecord);

        //总页数
        int allPage = 0;
        if (allRecord % pageRecord == 0){
            allPage = allRecord / pageRecord;
        }else {
            allPage = allRecord / pageRecord + 1;
        }

        //开始位置（数据库中）
        int startPosition = currentPage * pageRecord;

        //封装查询条件
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("news", news);
        map.put("startPosition", startPosition);
        map.put("pageRecord", pageRecord);

        //查询当前页的内容
        List<News> pageList = newsMapper.findNewsCurrentPageList(map);

        //封装pagebean返回给新闻分页页面
        PageBean<News> pageBean = new PageBean<News>();
        pageBean.setPageRecord(pageRecord);
        pageBean.setAllRecord(allRecord);
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageList(pageList);
        pageBean.setStartPosition(startPosition);
        pageBean.setAllPage(allPage);

        return pageBean;
    }

    //查询新闻的文件路径
    @Override
    public News findNewsContnet(int nid) {
        return newsMapper.findNewsContent(nid);
    }

    //编辑修改数据库中的新闻
    @Override
    public void editNews(News news) {
        newsMapper.eidtNews(news);
    }

    //添加新闻到数据库
    @Override
    public void addNews(News news) {
        newsMapper.addNews(news);
    }

    //删除新闻
    @Override
    public void deleteNews(int nid) {
        newsMapper.deleteNews(nid);
    }

    //新闻总记录数
    @Override
    public int findNewsCount(News news) {
        return newsMapper.findNewsCount(news);
    }


}
