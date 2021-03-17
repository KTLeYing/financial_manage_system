# financial_manage_system

# 理财管理系统系统【兼容PC端和手机端】

## 项目简介：

理财管理系统分为前台部分以及后台部分，面向的对象是普通用户和系统管理员，旨在为普通用户提供一个方便管理自己生活中的个人财务，做好收支记录，避免个人盲目过度消费的平台。个人理财管理系统能够为每普通用户者提供充足的信息和快捷的查询手段，大大方便个人的管理者的合理消费和理财。在这里，用户可以通过查询分析，统计出各项数据，分析出生活中的浪费和节约的地方，通过强大的查询和索检高效的索检出数据，提高理财办事效率。


## 采用技术 ： 
- 前端：HTML + CSS + JavaScript + Bootstrap + Jquery + Ajax + Highcharts + UEditor
- 后端：Spring Boot + Mybatis + Maven + Redis + RabbitMQ + Jwt + Shiro + AOP

## 开发环境 ：
- 工具：IDEA、Navicat、Git
- 环境：JDK 1.8、Tomcat 7.0、Mysql 8.0
- 项目管理：Maven
- 代码托管平台：GitHub

## 开发流程：  
1、数据库设计  
2、Model：模型定义，与数据库相匹配  
3、Dao层：数据操作  
4、Service:服务包装  
5、Controller：业务入口，数据交互   
6、Util：工具类封装   
7、Config：配置类封装    
8、单元测试    


## 功能模块 :  

**前台部分，主要功能分为以下几个模块：**

> 用户管理

- 用户注册✔
- 用户登录✔
- 用户修改密码✔
- 用户修改个人信息✔
- 用户注销登录✔

> 财务管理  

- 收入记账✔
- 支出记账✔
- 收支明细✔
- 修改记账信息✔
- 删除记账信息✔
- 搜索账单信息✔

> 收支类别管理

- 添加收入类别✔
- 添加支出类别✔

> 财务统计管理

- 按年度统计✔
- 按月度统计✔
- 按时间统计✔

> 财务分析管理

- 按月份分析（这个月和上个月同期对比）✔

> 财务预算管理

- 添加预算✔
- 编辑预算✔
- 删除预算✔
- 预算报表✔

> 心愿单管理

- 添加心愿✔
- 编辑心愿✔
- 删除心愿✔
- 我的心愿✔

> 备忘录管理

- 添加备忘✔
- 编辑备忘✔
- 删除备忘✔
- 我的备忘录✔

> 财务新闻管理

- 财务新闻列表✔
- 财务新闻信息✔

> 计算器管理

- 简易计算✔

**后台部分，主要功能分为以下几个模块：**

> 管理员管理

- 用户登录✔
- 用户注销✔

> 个人用户管理

- 用户查询列表✔
- 添加用户✔
- 修改用户信息✔
- 删除用户信息✔

> 收支类别管理

- 添加收入类型✔
- 添加支出类型✔
- 收支类别查询列表✔
- 修改收支类别信息✔
- 删除收支类别信息✔

> 财务新闻管理

- 财务新闻列表✔
- 财务新闻列表✔
- 修改财务新闻信息✔
- 添加财务新闻✔
- 删除财务新闻信息✔


## 项目截图：【系统兼容PC端和手机端】

**前台部分展示【PC端】：**

1. 登录页面  
![](https://img-blog.csdnimg.cn/20210317093530269.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70#pic_center)
2. 注册页面  
![](https://img-blog.csdnimg.cn/20210317093549850.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70#pic_center)
3. 用户信息页面  
![](https://img-blog.csdnimg.cn/20210317093717958.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70#pic_center)
4. 财政管理  
![](https://img-blog.csdnimg.cn/20210317093604128.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70#pic_center)
5. 财务统计
![](https://img-blog.csdnimg.cn/20210317093612670.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70#pic_center) 
![](https://img-blog.csdnimg.cn/20210317143132446.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70#pic_center) 
![](https://img-blog.csdnimg.cn/20210317143157558.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70#pic_center) 
![](https://img-blog.csdnimg.cn/20210317143213461.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70) 
![](https://img-blog.csdnimg.cn/20210317143213426.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70) 
![](https://img-blog.csdnimg.cn/20210317143213419.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70) 
![](https://img-blog.csdnimg.cn/20210317143315468.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70) 
![](https://img-blog.csdnimg.cn/20210317143315465.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70) 
![](https://img-blog.csdnimg.cn/20210317143315458.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70) 
![](https://img-blog.csdnimg.cn/20210317143315455.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70) 
6. 财务分析  
![](https://img-blog.csdnimg.cn/20210317093620720.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70#pic_center) 
7. 财务预算   
![](https://img-blog.csdnimg.cn/20210317093627581.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70#pic_center) 
8. 心愿单  
![](https://img-blog.csdnimg.cn/20210317093634248.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70#pic_center) 
9. 备忘录  
![](https://img-blog.csdnimg.cn/20210317093642141.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70#pic_center) 
10. 计算器  
![](https://img-blog.csdnimg.cn/20210317093649377.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70#pic_center) 
11. 财务新闻  
![](https://img-blog.csdnimg.cn/20210317093708988.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70#pic_center) 


**后台部分展示【PC端】：**

1. 登录页面  
![](https://img-blog.csdnimg.cn/20210317093731280.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70#pic_center)
2. 个人用户管理  
![](https://img-blog.csdnimg.cn/20210317093741716.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70#pic_center)
3. 收支类别管理  
![](https://img-blog.csdnimg.cn/20210317093752538.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70#pic_center)
4. 财务新闻管理  
![](https://img-blog.csdnimg.cn/20210317093802724.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70#pic_center)
![](https://img-blog.csdnimg.cn/20210317093810651.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70#pic_center)


**前台部分展示【手机端】：**

1. 菜单页面  
![](https://img-blog.csdnimg.cn/20210317143417491.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70)
2. 用户信息页面  
![](https://img-blog.csdnimg.cn/20210317143417688.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70)
3. 财政管理  
![](https://img-blog.csdnimg.cn/20210317143417538.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70)
4. 财务统计
![](https://img-blog.csdnimg.cn/20210317143417517.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70) 
5. 财务分析  
![](https://img-blog.csdnimg.cn/20210317143417541.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70)  
6. 心愿单  
![](https://img-blog.csdnimg.cn/20210317143417555.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70) 
7. 备忘录  
![](https://img-blog.csdnimg.cn/20210317143417515.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70) 
7. 财务新闻  
![](https://img-blog.csdnimg.cn/20210317143417769.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70) 


**后台部分展示【手机端】：**

1. 个人用户管理  
![](https://img-blog.csdnimg.cn/20210317143417751.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70)
2. 收支类别管理  
![](https://img-blog.csdnimg.cn/20210317143417745.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70)


## 项目访问 :  
浏览器访问路径： http://localhost:8080/financialmanage_war_exploded/
