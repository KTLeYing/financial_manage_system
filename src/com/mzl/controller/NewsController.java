package com.mzl.controller;

import com.mzl.pojo.News;
import com.mzl.pojo.PageBean;
import com.mzl.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * @ClassName :   NewsController
 * @Description: 理财新闻
 * @Author: 21989
 * @CreateDate: 2020/6/19 22:09
 * @Version: 1.0
 */
@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    //新闻列表
    @RequestMapping("/findNewsList.action")
    public String findNewsList(News news, Integer currentPage, Model model){
        System.out.println(news);
        System.out.println(currentPage);
        //无条件分页查询+有条件分页查询
        //查询条件：文章标题+文章作者+文章关键字     +  当前页
        //当前页，默认情况下，currentPage=0   提交过来是第1页

        model.addAttribute("findNews", news);

        //分页查询新闻列表
        PageBean<News> pageBean = newsService.findNewsList2(news, currentPage);
        if (pageBean.getPageList().size() == 0){
            //确保为空
            pageBean.setPageList(null);
        }

        //分页查询的结果
        model.addAttribute("pageBean", pageBean);

        //跳转到新闻列表页面
        return "/jsp/newsList.jsp";
    }

    //通过id，查询新闻信息
    @RequestMapping("/news.action")
    public String toEditPage(Integer nid,Model model, HttpServletRequest request) throws IOException {
        //通过id查询当前新闻信息
        News news = newsService.queryNewsById(nid);
        // 根据新闻路径，读取新闻文件内容，显示在页面上

        //点击一次新闻链接，阅读量加1
        newsService.addVisitCount(nid);

        //获取文章路径
        String thingPath= news.getnContent();
        System.out.println(thingPath);

        //获取目标文件路径
        String string = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println(string);
        int num = string.indexOf("financialmanage");
        String path = string.substring(1,num).replace('/', '\\') + "financialmanage\\";
        System.out.println(path);
        String realPath = path + "web\\file\\news\\" + thingPath;
        System.out.println(realPath);

//        String path = request.getSession().getServletContext().getRealPath("/"); //表示到项目的根目录下，要是想到目录下的子文件夹，修改"/"即可
//        System.out.println(path);
//        String[] arr = path.split("out");
//        System.out.println(arr[0]);
//        String realPath = arr[0] + "web\\file\\news\\" + thingPath;
//        System.out.println(realPath);

        // 读取文件内容，写到String中
        int len = 0;
        StringBuffer str = new StringBuffer("");
        File file = new File(realPath);
        try {
            FileInputStream is = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(is,"UTF-8");
            BufferedReader in = new BufferedReader(isr);

            System.out.println("kkk");

            String line = null;
            while ((line = in.readLine()) != null){
                if (len != 0){
                    //处理换行符的问题
                    str.append(line );
                    System.out.println(line);
                }else {
                    str.append(line);
                    System.out.println(line);
                }
                len++;
            }
            System.out.println(is);
            System.out.println(isr);
            System.out.println(in);
            in.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //内容
        String content = str.toString();

        System.out.println("content:" + content);//新闻内容

        model.addAttribute("content", content);
        //信息
        model.addAttribute("news", news);

        // 到编辑页面
        return "/jsp/news.jsp";
    }

}
