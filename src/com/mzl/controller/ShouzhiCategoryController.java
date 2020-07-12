package com.mzl.controller;

import com.mzl.pojo.ShouzhiCategory;
import com.mzl.service.ShouzhiCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName :   ShouzhiCategoryController
 * @Description: 收支类型
 * @Author: 21989
 * @CreateDate: 2020/6/19 16:04
 * @Version: 1.0
 */
@Controller
@RequestMapping("/shouzhiCategory")   //访问路径是  /shouzhiCategory/xxx
public class ShouzhiCategoryController {

    @Autowired
    private ShouzhiCategoryService shouzhiCategoryService;

    //添加收支类型
    @RequestMapping("addShouzhiCategory.action")
    @ResponseBody
    public String addShouzhiCategory(ShouzhiCategory shouzhiCategory){
        shouzhiCategoryService.addShouzhiCategory(shouzhiCategory);
        return "OK";
    }

    //ajax请求    收支子类型是否存在
    @RequestMapping(value = "findsonCategoryByNameAndAjax.action", method = RequestMethod.POST)
    @ResponseBody
    public String findsonCategoryByNameAndAjax(String son_category){
        System.out.println(son_category);
        //用收支子类型和父类型来查找收支的子类型对应各自是否存在
        ShouzhiCategory result = shouzhiCategoryService.findCategoryBySonCategory(son_category);
        System.out.println(result);
        if(result!=null){
            return "{\"name\":\"exit\"}";//json格式
        }
        else{
            return "{\"name\":\"notexit\"}";//不存在
        }
    }


}
