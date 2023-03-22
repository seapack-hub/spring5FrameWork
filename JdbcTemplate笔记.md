JdbcTemplate(概念和准备)
1、什么是 JdbcTemplate
（1）Spring 框架对 JDBC 进行封装，使用 JdbcTemplate 方便实现对数据库操作
2、准备工作
（1）引入相关 jar 包
  ![](E:\我的代码\Java学习项目\springFrameWork\spring5FrameWork\src\public\JdbcTemplate\IdbcTemplate依赖.png)
（2）在 spring 配置文件配置数据库连接池
<!-- 数据库连接池 -->
<!---->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource" destroy-method="close">
        <property name="url" value="jdbc:mysql:///user_db" />
        <property name="username" value="root" />
        <property name="password" value="root" />
        <property name="driverClassName" value="com.mysql.jdbc.Driver" />
    </bean>
（3）配置 JdbcTemplate 对象，注入 DataSource
 <!--JdbcTemplate对象-->
    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <!--注入DataSource-->
        <property name="dataSource" ref="dataSource"></property>
    </bean>
（4）创建 service 类，创建 dao 类，在 dao 注入 jdbcTemplate 对象
* 配置文件
* <!-- 组件扫描 -->
  <context:component-scan base-package="com.company.spring5.JdbcTemplate"></context:component-scan>
---------------------------------------------------------------------------------------------------------------------------
