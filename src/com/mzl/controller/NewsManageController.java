package com.mzl.controller;

import com.mzl.pojo.News;
import com.mzl.pojo.PageBean;
import com.mzl.service.NewsService;
import com.sun.org.apache.xalan.internal.xsltc.dom.SimpleResultTreeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.UUID;

/**
 * @ClassName :   NewsManageController
 * @Description: 新闻管理（管理员）
 * @Author: 21989
 * @CreateDate: 2020/7/8 23:39
 * @Version: 1.0
 */
@Controller
@RequestMapping("/newsManage")
public class NewsManageController {

    //注入依赖
    @Autowired
    private NewsService newsService;

    //分页查询新闻列表
    @RequestMapping("/findNewsList.action")
    public String findNewsList(News news, Integer currentPage, Model model){
        //查询条件： 文章标题 + 文章作者 + 文章关键字 + 当前页
        //当前页，默认下是currentPage = 0（即第一页）

        //封装查询条件数据在model，用于返回页分页页面的查询条件的回显
        model.addAttribute("findNews", news);

        //分页查询新闻列表
        PageBean<News> pageBean = newsService.findNewsList(news, currentPage);

        //封装数据在model里面，返回到分页列表页面使用
        model.addAttribute("pageBean", pageBean);

        //返回到新闻分页列表页面
        return "/admin/newsManage.jsp";
    }

    //去编辑页面
    @RequestMapping("/toEditPage.action")
    public String toEditPage(int nid, Integer currentPage, Model model) throws IOException {
        //查询新闻的内容，用于回显在Ueditor编辑器里
        //查询新闻的信息
        News news =  newsService.findNewsContnet(nid);
        System.out.println("news:" + news);
        //获取新闻路径
        String nContent = news.getnContent();
        System.out.println(nContent);

        //获取目标文件的根路径
        String string = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println(string);
        int num = string.indexOf("financialmanage");
        System.out.println(num);
        String path = string.substring(1, num).replace("/", "\\") + "financialmanage\\";
        System.out.println(path);

        //真正的文件路径
        String realPath = path + "web\\file\\news\\" + nContent;
        System.out.println("realPath:" + realPath);

        //读取文件内容写到stringbuffer中
        int len = 0;
        StringBuffer stringBuffer = new StringBuffer("");
        try {
            //创建文件对象
            File file = new File(realPath);
            //创建输入流对象
            FileInputStream fileInputStream = new FileInputStream(file);
            //创建输入流的读对象
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            //创建读对象的缓冲区对象
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            //开始读取文件
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                stringBuffer.append(line);
                System.out.println(line);
                len++;
            }
            System.out.println(len);

            //关闭
            bufferedReader.close();
            inputStreamReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //stringBUffer转为string
        String content = stringBuffer.toString();
        System.out.println(content);

        //封装数据到model里，前端页面要使用
        model.addAttribute("content", content);
        model.addAttribute("news", news);
        model.addAttribute("currentPage", currentPage);

        //返回到编辑页面
        return "/admin/news/editnews.jsp";
    }

    //编辑新闻
    @RequestMapping("/editNews.action")
    public String editNews(News news, Integer currentPage2, String editvalue, HttpServletRequest request){
        //拿到编辑器的原文本的内容(带有标签的格式)
        System.out.println(news);
        System.out.println(editvalue);
        System.out.println(currentPage2);

        //获取新闻编辑器原来内容，带有标签的（editorValue是编辑器自己自带提交的一个内容值，为editorValue，不需我们设置，我们可以通过这个值来获取原带标签的内容）
        String content = request.getParameter("editorValue");
        System.out.println(content);

        //把文本写入文件
        //获取文件路径
        String nContent = news.getnContent();
        //获取根路径
        String string = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println(string);
        int num = string.indexOf("financialmanage");
        System.out.println(num);
        String path = string.substring(1, num).replace("/", "\\") + "financialmanage\\";
        System.out.println(path);

        //真正的文件路径
        String realPath = path + "web\\file\\news\\" + nContent;
        System.out.println(realPath);

        //把内容写入，覆盖到文件中
        try {
            //创建文件对象
            File file = new File(realPath);
            //创建输出流对象
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            //创建输出流写对象
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
            //创建写对象的缓存区对象
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            //向文件中写入信息
            bufferedWriter.write(content);

            //关闭
            bufferedWriter.close();
            outputStreamWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        //编辑修改数据库中的新闻
        newsService.editNews(news);

        //返回到原来分页查询列表页面
        return "redirect:/newsManage/findNewsList.action?currentPage=" + currentPage2;
    }

    //添加新闻
    @RequestMapping("/addNews.action")
    public String addNews(News news, HttpServletRequest request, MultipartFile file, String editvalue) throws IOException {
        System.out.println(news);
        System.out.println(file);
        System.out.println(editvalue);
        //判断逻辑，方式二的文件名不为空，则以方式的形式上传文件，否则，以方式一的形式上传文件
        //随机获取一个文件名
        String fileName = generateUUIDName();
        System.out.println(fileName);

        //上传文件的路径
        String string = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println(string);
        int num = string.indexOf("financialmanage");
        String path = string.substring(1, num).replace("/", "\\") + "financialmanage\\";
        System.out.println(path);

        //真正的路径
        String realPath = path + "web\\file\\news\\" + fileName;

        //写入数据库的文件后缀名
        String expandName = "";

        //方式二上传
        //上传的为空名不为空值而且不为空
        if (file.getOriginalFilename() != "" && file.getOriginalFilename() != null){
            System.out.println("方式二：上传文件");
            //获取文件名
            String oriName = file.getOriginalFilename();
            System.out.println(oriName);
            //获取后缀名
            String extName = oriName.substring(oriName.lastIndexOf("."));
            System.out.println(extName);
            expandName = extName;
            //上传的文件的真正完整的路径
            realPath = realPath + extName;
            System.out.println(realPath);

            //springmvc上传文件
            file.transferTo(new File(realPath));
        }else {
            //以方式一上传
            //拿到编译器的内容（原内容，带有标签的）
            String content = request.getParameter("editorValue");
            //文件的真正最终路径
            realPath = realPath + ".txt";
            System.out.println(realPath);

            //写入数据库的后缀名
            expandName = ".txt";

            //开始写内容进去文件
            //创建文件对象
            File file1 = new File(realPath);
            //创建文件输出流
            FileOutputStream fileOutputStream = new FileOutputStream(file1);
            //创建输出流的文件写对象
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
            //创建写对象的输出缓冲区
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            //把新闻内容写入文件中
            bufferedWriter.write(content);
            //关闭
            bufferedWriter.close();
        }

        //添加到数据库的文件名(带后缀名)
        String nContent = fileName + expandName;
        System.out.println(nContent);

        //添加新闻到数据库
        news.setnContent(nContent);
        news.setVisitCount(0);
        newsService.addNews(news);

        //添加成功后，返回到新闻列表的第一页
        return "redirect:/newsManage/findNewsList.action";
    }

    //随机生成一个文件名
    private String generateUUIDName() {
        return UUID.randomUUID().toString();
    }

    //删除新闻
    @RequestMapping("/deleteNews.action")
    public String deleteNews(Integer currentPage2, int nid){
        System.out.println(currentPage2);
        //删除新闻
        newsService.deleteNews(nid);

        //处理删除前是在最后一页，且只有一条记录，删掉的就是这一条记录，则当前页减-1，回去上一页
        //每页记录数
        int pageRecord = 10;

        //封装nid在news对象里，可以重复使用分页查询的代码
        News news = new News();
        //总记录数
        int allRecord = newsService.findNewsCount(news);
        System.out.println(news);

        //总页数
        int allPage = 0;
        if (allRecord % pageRecord == 0){
            allPage = allRecord / pageRecord;
        }else {
            allPage = allRecord / pageRecord + 1;
        }
        System.out.println(allPage);

        //处理currentPage（针对是原来最后一页，且只有一条数据）
        if (currentPage2 >= allPage){
            currentPage2 = currentPage2 - 1;   //返回最后一页的前一页
        }
        System.out.println(currentPage2);

        //重定向返回到原来的那一页
        return "redirect:/newsManage/findNewsList.action?currentPage=" + currentPage2;

    }


}
