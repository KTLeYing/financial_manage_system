package com.mzl.mapper;

import com.mzl.pojo.News;

import java.util.List;
import java.util.Map;

/**
 * @InterfaceName :   NewsMapper
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/18 18:41
 * @Version: 1.0
 */
public interface NewsMapper {

    //查出8条财务新闻，通过录入时间 和  访问量的多少来决定显示
    List<News> findNewsEightList();

    // 查询新闻总记录数
    int findNewsCount(News news);

    // 分页查询新闻当前页记录列表
    List<News> findNewsCurrentPageList(Map<String, Object> map);

    //通过id查询当前新闻信息
    News queryNewsById(Integer nid);

    //访问一次新闻，阅读量加1
    void addVisitCount(Integer nid);

    //查询新闻的文件路径
    News findNewsContent(int nid);

    //编辑修改数据库中的新闻
    void eidtNews(News news);

    //添加新闻到数据库
    void addNews(News news);

    //删除新闻
    void deleteNews(int nid);
}
