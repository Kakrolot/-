＃ - 这是一个利用SSM框架搭建的网站，主要实现的功能是对整个物流系统的后台的部门人员和部门进行管理
    
独立的搭建SSM框架，对applicationContext.xml   SpringMvc-config  mybatis-config文件进行配置

数据库用的是Mysql数据库 设置好每个表的主键外键，然后通过mybatis的配置与数据库进行连接，然后通过Mapper文件与接口实现对数据库的增删该查

前端页面使用Ajax+JSP 与后台互联实现网页的动态呈现。局部和整体刷新。

用tomcat服务器进行发布预览实现效果。

核心是利用SSM框架实现 aop进行面向切面的编程。
