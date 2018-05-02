# mysql读写分离


## 原理图
![](https://github.com/xiaopengxpgithub/mysqlreadwrite/blob/master/src/main/images/%E5%8E%9F%E7%90%86%E5%9B%BE.png)

## 说明
1. controller调用service方法之前使用aop代理进行当前用户访问请求与我们的数据源的字符串建立映射关系

2. 在dao方法执行之前根据指定的数据源字符串(路由规则),找到对应的数据源实例,进行对应的操作

3. 多个数据源实例之间配置了主从复制功能,当用户在”写库”中插入数据之后,数据会自动同步到”读库”,当用户需要读取数据时,会根据路由规则,去”读库”中读取数据,实现读写分离!!!
