# crosstime

constributor:魏宇弘，陆羿辰

最终功能：实现小程序内实时电话沟通，

**7.19编辑（陆羿辰）：**

现阶段：前端完成基础框架搭建，未完成声网agora插件部署、图片替换（保存于static/exchangeimage）、res内用户数据传递

后端完成用户登录注册功能，未完成部署、返回前端用户数据功能

数据库存在table：user

项目概述：

技术栈：uni-app, springboot, mybatis

部署步骤：

后端使用MySQLworkbench打开springboot项目中resource下的mwb文件，生成script在local instance mysql中运行

根据自身情况修改application.yml文件中DataSource下的url，username，password

运行crosstimemain.java文件

前端使用hbuilderX打开‘uni’项目文件夹， 打开pages文件夹下vue文件，预览
