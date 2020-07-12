package com.mzl.controller;

import com.alibaba.fastjson.JSON;
import com.mzl.pojo.PageBean;
import com.mzl.pojo.ShouzhiCategory;
import com.mzl.pojo.ShouzhiRecord;
import com.mzl.service.CategoryManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName :   CategoryManageController
 * @Description: 收支类型管理（管理员）
 * @Author: 21989
 * @CreateDate: 2020/7/8 15:31
 * @Version: 1.0
 */
@Controller
@RequestMapping("/categoryManage")
public class CategoryManageController {

    //注入依赖
    @Autowired
    private CategoryManageService categoryManageService;

    //分页查询收支类型
    @RequestMapping("/findCategorys.action")
    public String findCategorys(ShouzhiCategory shouzhiCategory, Integer currentPage, Model model){
        //查询条件：收支类型 + 收支子类型 + 当前页
        //默认下，当前页currentPage为0（即第一页）

        //设置设置查询条件，用于返回页面回显信息
        model.addAttribute("findShouzhiCategory", shouzhiCategory);

        //分页查询收支类型
        PageBean<ShouzhiCategory> pageBean = categoryManageService.findCategorys(shouzhiCategory, currentPage);

        //如果不存在任何数据，设置list空，返回页面时做判断list是空，就不会显示分页栏，并提示无数据
        if (pageBean.getPageList().size() == 0){
            pageBean.setPageList(null);
        }

        //设置分页结果，装入model中，返回给分页列表页面
        model.addAttribute("pageBean", pageBean);

        //返回收支类型页面
        return "/admin/categoryManage.jsp";
    }

    //ajax查询是否存在收支对应的子类型
    @RequestMapping("/ajaxFindCategory.action")
    @ResponseBody
    public String ajaxFindCategory(ShouzhiCategory shouzhiCategory){
        //查询是否存在该收支类型
        ShouzhiCategory findCategory = categoryManageService.findCategory(shouzhiCategory);

        if (findCategory == null){//不存在
            return "{\"name\":\"no\"}";  //返回json数据格式
        }else {  //存在
            return "{\"name\":\"yes\"}";   //返回json数据格式
        }
    }

    //添加收支类型
    @RequestMapping("/addCategory.action")
    public String addCategory(ShouzhiCategory shouzhiCategory, Integer currentPage){
        //添加收支类型
        categoryManageService.addCategory(shouzhiCategory);
        //重定向到收支类型分页列表
        return "redirect:/categoryManage/findCategorys.action?currentPage=" + currentPage;
    }

    //去修改页面，用于回显信息
    @RequestMapping("/toEditPage.action")
    @ResponseBody
    public String toEditPage(Integer szcid){
        //查询该收支类型信息,用于回显
        ShouzhiCategory shouzhiCategory = categoryManageService.toEditPage(szcid);

        //把数据封装成map
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("shouzhiCategory", shouzhiCategory);
        map.put("old_son_category", shouzhiCategory.getSon_category());

        //转为json数据
        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);

        //返回给respose对象的body去，即js中的ajax的请求后回调函数那里
        return jsonString;
    }

    //修改收支类型
    @RequestMapping("/editShouzhiCategory.action")
    public String editShouzhiCategory(ShouzhiCategory shouzhiCategory, Integer currentPage2){
        System.out.println(shouzhiCategory);
        System.out.println(currentPage2);
        //修改收支子类型
        categoryManageService.editShouzhiCategory(shouzhiCategory);

        //重定向到原来那一页的分页列表
        return "redirect:/categoryManage/findCategorys.action?currentPage=" + currentPage2;
    }

    //ajax判断能不变删除该收支类型
    @RequestMapping("/ajaxConfirmDeleteShouzhiCategory.action")
    @ResponseBody
    public String ajaxConfirmDeleteShouzhiCategory(int szcid){
        //查询记录表中是否有使用该收支类型
        int count = categoryManageService.countCategory(szcid);
        System.out.println(count);
        if (count == 0){//可删
            return "{\"name\":\"yes\"}";  //json格式
        }else { //不能删
            return "{\"name\":\"no\"}";   //json格式
        }
    }

    //删除收支类型
    @RequestMapping("/deleteShouzhiCategory.action")
    public String deleteShouzhiCategory(int szcid, Integer currentPage2){
        //删除收支类型
        categoryManageService.deleteShouzhiCategory(szcid);

        //处理删除前，该删除的记录是在最后一页，且最后一页只有一条记录，删除的记录就是这一条记录来的的问题
        //每页的记录数
        int pageRecord = 10;
        //删除后总记录数
        int allRecord = categoryManageService.countAllCategory();
        System.out.println(allRecord);

        //更新总页数
        int allPage = 0;
        if (allRecord % pageRecord == 0){
            allPage = allRecord / pageRecord;
        }else {
            allPage = allRecord / pageRecord + 1;
        }
        System.out.println(allPage);

        //判断总页数和当前页数的关系，重新赋值currentPage
        if (currentPage2 >= allPage){
            currentPage2 = currentPage2 - 1;
        }
        System.out.println(currentPage2);

        //重定向到分页列表原来那一页
        return "redirect:/categoryManage/findCategorys.action?currentPage=" + currentPage2;
    }


}
