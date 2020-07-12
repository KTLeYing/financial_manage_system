package com.mzl.controller;

import com.mzl.pojo.Memorandum;
import com.mzl.pojo.PageBean;
import com.mzl.pojo.User;
import com.mzl.service.MemorandumService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @ClassName :   MemorandumController
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/7/6 17:51
 * @Version: 1.0
 */
@Controller
@RequestMapping("/memorandum")
public class MemorandumController {

    //注入依赖
    @Autowired
    private MemorandumService memorandumService;

    //显示所有的备忘录，分页查询
    @RequestMapping("/listMemorandum.action")
    public  String listMemorandum(HttpServletRequest request, Integer currentPage, Model model){
        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            return "/index.jsp";  //还没登录，重新登录
        }

        int uid = user.getUid();

        //显示所有当前页的备忘录，分页查询
        PageBean<Memorandum> pageBean = memorandumService.listMemorandum(uid, currentPage);

        //无数据则确保为空，前端会不显示数据和分页栏
        if (pageBean.getPageList().size() == 0){
            pageBean.setPageList(null);
        }

        //把数据放到model里面，通过attribute来设置和获取数据
        model.addAttribute("pageBean", pageBean);

        return "/jsp/memorandum/memorandum.jsp";
    }

    //去编辑页面
    // 当前备忘录
    @RequestMapping("/oneMemorandum.action")
    public String oneMemorandum(HttpServletRequest request, int mid, Model model, Integer currentPage) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            //重新登录
            return "/index.jsp";
        }

        int uid = user.getUid();

        //封装查询条件
        Memorandum me = new Memorandum();
        me.setUser_id(uid);
        me.setMid(mid);

        //备忘录信息
        //查询当前的备忘录
        Memorandum memorandum = memorandumService.oneMemorandum(me);

        //根据备忘录路径，读取备忘录的文件内容，显示在页面上
        //备忘录的路径
        String thingPath = memorandum.getThingPath();
        System.out.println(thingPath);

        //获取目标文件路径
        String string = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println(string);
        int num = string.indexOf("financialmanage");
        String path = string.substring(1,num).replace('/', '\\') + "financialmanage\\";
        System.out.println(path);
        String realPath = path + "web\\file\\memorandum\\" + thingPath;
        System.out.println(realPath);

//        String path = request.getSession().getServletContext().getRealPath("/"); //表示到项目的根目录下，要是想到目录下的子文件夹，修改"/"即可
//        System.out.println(path);
//        String[] arr = path.split("out");
//        System.out.println(arr[0]);
//        String realPath = arr[0] + "web\\file\\memorandum\\" + thingPath;
//        System.out.println(realPath);

        //读取文件内容,写到string中
        int len = 0;
        StringBuffer str = new StringBuffer("");
        File file = new File(realPath);
        try {
            FileInputStream is = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            BufferedReader in = new BufferedReader(isr);
            String line = null;
            while ((line = in.readLine()) != null){
                if (len != 0){
                    //处理换行符问题
                    str.append(line);
                    System.out.println(line);
                }else {
                    str.append(line);
                    System.out.println(line);
                }
                len++;
            }

            in.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //内容
        String content = str.toString();
        System.out.println("content:" + content);
        //内容
        model.addAttribute("content", content);
        //信息
        model.addAttribute("memorandum", memorandum);
        //记住当前页
        model.addAttribute("currentPage", currentPage);

        //返回到编辑页面
        return "/jsp/memorandum/editmemorandum.jsp";
    }

    //编辑备忘录
    @RequestMapping("/editMemorandum.action")
    public String editMemorandum(HttpServletRequest request, Memorandum memorandum, String editvalue, Model model, Integer currentPage) throws IOException{
        System.out.println(memorandum);
        System.out.println(editvalue);

        //需要修改 1、文件内容：覆盖原来的文件  2、文件的头80个字符
        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            return "/index.jsp";  //重新登录
        }

        int uid = user.getUid();

        //编辑不为空是，才可以上传
        String topFont = null;
        if (editvalue.length() > 80){
            topFont = editvalue.substring(0, 80);
        }else {
            topFont = editvalue;
        }

        //获取编辑器的内容
        String content = request.getParameter("editorValue");
        System.out.println("ffff");
        System.out.println(content);

        //写文件到那个路径
        String thingPath = memorandum.getThingPath();

        //获取目标文件路径
        String string = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println(string);
        int num = string.indexOf("financialmanage");
        String path = string.substring(1,num).replace('/', '\\') + "financialmanage\\";
        System.out.println(path);
        String realPath = path + "web\\file\\memorandum\\" + thingPath;
        System.out.println(realPath);

//        String path = request.getSession().getServletContext().getRealPath("/");
//        String[] arr = path.split("out");
//        System.out.println(arr[0]);
//        String realPath = arr[0] + "web\\file\\memorandum\\" + thingPath;
//        System.out.println(realPath);

        //将编辑器的内容写到原文件中，覆盖原来的文件
        //创建文件对象
        File fileText = new File(realPath);
        //创建文件输出流对象
        FileOutputStream fileOutputStream = new FileOutputStream(fileText);
        //创建输出写对象
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");
        //创建输出缓存对象
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        //向文件中写入content
        bufferedWriter.write(content);

        bufferedWriter.close();
        fileOutputStream.close();

        //创建文件写入对象，用于写入信息到文件中
//        FileWriter fileWriter = new FileWriter(fileText);
        //向文件中写入string内容
//        fileWriter.write(content);
//        //关闭写操作对象
//        fileWriter.close();

        memorandum.setTopFont(topFont);
        memorandum.setUser_id(uid);

        //编辑备忘录
        memorandumService.editMemorandum(memorandum);

        //返回备忘录查询列表页面
        return "redirect:/memorandum/listMemorandum.action?currentPage=" + currentPage;

    }

    //添加备忘录
    @RequestMapping("/addMemorandum.action")
    public String addMemorandum(HttpServletRequest request, String editvalue) throws IOException{
        System.out.println(editvalue);

        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            return "/index.jsp";
        }

        int uid = user.getUid();
        //编辑器不为空，才上传
        String topFont = null;
        if (editvalue.length() > 80){
            //前80个字的内容为标题
            topFont = editvalue.substring(0, 80);
        }else {
            topFont = editvalue;
        }

        //获取编辑器的内容
        String content = request.getParameter("editorValue");

        //当前时间
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String recordTime = dateFormat.format(date);

        //将编辑器的内容写进文件里面的存储路径为
        //获取目标文件路径
        String string = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println(string);
        int num = string.indexOf("financialmanage");
        String path = string.substring(1,num).replace('/', '\\') + "financialmanage\\";
        System.out.println(path);

//        String path  = request.getSession().getServletContext().getRealPath("/");
//        System.out.println(path);
//        String[] arr = path.split("out");
//        System.out.println(arr[0]);

        //生成唯一的文件名
        String filePath = generateUUIDName();
        System.out.println("随机生成的文件名:" + filePath);

        //文件的全名（带后缀名）
        String thingPath = filePath + ".txt";

        //真正的文件路径
        String realPath = path + "web\\file\\memorandum\\" + thingPath;
        System.out.println(realPath);

        //创建文件对象
        File file = new File(realPath);
        //创建文件输出流
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        //创建文件写对象,用于写文件
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
        //创建写对象的输出缓存区
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        //把String内容写到目标文件中
        bufferedWriter.write(content);

        //关闭文件流
        bufferedWriter.close();
        fileOutputStream.close();

        //把备忘录信息添加到数据库
        //封装要添加的数据
        Memorandum memorandum = new Memorandum();
        memorandum.setUser_id(uid);
        memorandum.setTopFont(topFont);
        memorandum.setRecordTime(recordTime);
        memorandum.setThingPath(thingPath);

        //添加到备忘录
        memorandumService.addMemorandum(memorandum);

        //重定向到备忘录查询列表页面
        return "redirect:/memorandum/listMemorandum.action";
    }

    //删除备忘录
    @RequestMapping("/deleteMemorandum.action")
    public String deleteMemorandum(HttpServletRequest request, int mid, Integer currentPage){
        System.out.println(currentPage);

        //删除备忘录
        memorandumService.deleteMemorandum(mid);

        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            return "/index.jsp";  //重新登录
        }

        int uid = user.getUid();
        //查询数据库，看现在有多少数据，如果删除前当前页是之后一页，如果计算少了一页，则显示上一页的数据，如果没少，删了后最后一页还有数据，则还是显示最后页的数据
        //每页记录数
        int pageRecord = 6;
        //查询总记录数
        int allRecord = memorandumService.findMemorandumCount(uid);
        System.out.println(allRecord);

        //处理返回的总页数
        int allPage = 0;
        if (allRecord % pageRecord == 0){
            allPage = allRecord / pageRecord;
        }else {
            allPage = allRecord / pageRecord + 1;
        }

        //处理返回的当前页数
        if(currentPage > allPage - 1){
            currentPage = currentPage - 1;
        }

        //返回到备忘录查询列表，返回删除前的那一页（除了最后一页的特殊情况）
        return "redirect:/memorandum/listMemorandum.action?currentPage=" + currentPage;
    }

    //随机生成文件名
    public String generateUUIDName(){
        return UUID.randomUUID().toString();
    }


}
