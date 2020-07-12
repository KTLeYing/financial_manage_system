package com.mzl.controller;

import com.alibaba.fastjson.JSON;
import com.mzl.pojo.PageBean;
import com.mzl.pojo.User;
import com.mzl.pojo.WishList;
import com.mzl.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName :   WishListController
 * @Description: 心愿单控制器
 * @Author: 21989
 * @CreateDate: 2020/7/6 12:58
 * @Version: 1.0
 */
@Controller
@RequestMapping("/wishlist")   //访问路径（对应类的）
public class WishListController {

    //注入依赖
    @Autowired
    private WishListService wishListService;

    //查询所有的心愿单
    @RequestMapping("/findAllWishList.action")
    public String findAllWishList(HttpServletRequest request, Model model, Integer currentPage){
        //分页查询currentPage
        User user = (User) request.getSession().getAttribute("user");
        System.out.println(user.getUid());
        System.out.println(currentPage);

        //分页查询心愿单当前页
        PageBean<WishList> pageBean = wishListService.findAllWishList(user.getUid(), currentPage);

        //确保为空
        if (pageBean.getPageList().size() == 0){
            pageBean.setPageList(null);
        }

        model.addAttribute("pageBean", pageBean);

        return "/jsp/wishlist.jsp";
    }

    //添加心愿单
    @RequestMapping("/addWish.action")
    @ResponseBody
    public String addWish(WishList wishList){
        System.out.println(wishList);
        //获取yyyy-MM-dd的格式时间
       String currentTime = wishList.getWdate();
       //心愿单id
       String wid = "";
       //获取某人某天的心愿单个数
        int count = wishListService.countWishListByTimeAndId(wishList);
        System.out.println(count);

        count = count + 1;
//        count += 1;
        if (count + 1 < 10){
            wid = "心愿单" + currentTime + "-0" + count;
        }else {
            wid = "心愿单" + currentTime + "-" + count;
        }

        String state = "未完成";
        wishList.setState(state);
        wishList.setWid(wid);

        //添加心愿单
        wishListService.addWish(wishList);

        return "OK";
    }

    //回显心愿单，根据id查询心愿单信息
    @RequestMapping("/toEdit.action")
    @ResponseBody
    public String toEdit(Long id){
        //失败原因：mybatis中没有写返回值
        //查询心愿信息
        WishList findWishList = wishListService.findWishById(id.intValue());  //转为int类型

        //转为json格式数据
        String jsonString  = JSON.toJSONString(findWishList);
        System.out.println("jsonString:" + jsonString);

        return jsonString;
    }

    //编辑心愿单
    @RequestMapping("/editWish.action")
    @ResponseBody
    public String editWish(WishList wishList){
        System.out.println(wishList);
        String wid = null;
        String currentTime = wishList.getWdate();
        //获取某人，某天的心愿单个数
        int count = wishListService.countWishListByTimeAndId(wishList);
        count = count + 1;
        if (count + 1 < 10){
            wid = "心愿单" + currentTime + "-0" + count;
        }else {
            wid = "心愿单" + currentTime + "-" + count;
        }

        wishList.setWid(wid);

        //更新心愿单
        wishListService.editWish(wishList);

        return "OK";
    }

    //删除心愿单
    @RequestMapping("/deleteWish.action")
    @ResponseBody
    public void deleteWish(int id){
        //删除心愿单
        wishListService.deleteWish(id);

        return;
    }



}
