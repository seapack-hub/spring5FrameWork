~~1、什么是 IOC
（1）控制反转，把对象创建和对象之间的调用过程，交给 Spring 进行管理
（2）使用 IOC 目的：为了耦合度降低
（3）做入门案例就是 IOC 实现
2、IOC 底层原理
（1）xml 解析、工厂模式、反射

1、IOC 思想基于 IOC 容器完成，IOC 容器底层就是对象工厂
2、Spring 提供 IOC 容器实现两种方式：（两个接口）
（1）BeanFactory：IOC 容器基本实现，是 Spring 内部的使用接口，不提供开发人员进行使用
* 加载配置文件时候不会创建对象，在获取对象（使用）才去创建对象
  （2）ApplicationContext：BeanFactory 接口的子接口，提供更多更强大的功能，一般由开发人
  员进行使用
* 加载配置文件时候就会把在配置文件对象进行创建

---------------------------------------------------------------------------------------------------------------------------
1、什么是 Bean 管理
（0）Bean 管理指的是两个操作
（1）Spring 创建对象
（2）Spring 注入属性

2、Bean 管理操作有两种方式
（1）基于 xml 配置文件方式实现
     <bean id="user" class="com.company.spring5.User"></bean>
    （1）在 spring 配置文件中，使用 bean 标签，标签里面添加对应属性，就可以实现对象创建
    （2）在 bean 标签有很多属性，介绍常用的属性
      * id 属性：唯一标识
      * class 属性：类全路径（包类路径）
      * name 属性：功能和id类似，区别：name可以加特殊符号，id不行
    （3）创建对象时候，默认也是执行无参数构造方法完成对象创建

（2）基于注解方式实现
   （1）DI：依赖注入，就是注入属性
    第一种注入方式：使用 set 方法进行注入,创建类，定义属性和对应的 set 方法
    public class Book {
        //创建属性
        private String bookName;
        private String bookAuthor;
        //创建属性对应的 set 方法
        public void setBookName(String bookName) {
          this.bookName = bookName;
        }
        public void setBookAuthor(String bookAuthor) {
          this.bookAuthor = bookAuthor;
        }
    }
    第二种注入方式：使用有参数构造进行注入,创建类，定义属性，创建属性对应有参数构造方法
    public class Orders {
      //属性
      private String oname;
      private String address;
      //有参数构造
      public Orders(String oname,String address) {
        this.oname = oname;
        this.address = address;
      }
    }

  (3)使用 p 名称空间注入，可以简化基于 xml 配置方式
    第一步 添加 p 名称空间在配置文件中
    xmlns:p="http://www.springframework.org/schema/p"
    第二步 进行属性注入，在 bean 标签里面进行操作
    <bean id="book" class="com.company.spring5.Book" p:bookName="毛泽东选集" p:bookAuthor="毛泽东"></bean>

---------------------------------------------------------------------------------------------------------------------------
IOC 操作 Bean 管理（xml 注入其他类型属性）
1.字面量
    (1) null值
    <property name="address">
    <null></null>
    </property>
    (2) 属性值具有特殊符号
      1. 把<>进行转义 &lt; &gt;
      2. 把特殊符号内容写到CDATA中
    <property name="address">
        <value><![CDATA[<<南京>>]]></value>
    </property>

----------------------------------------------------------------------------------------------------------------------------
IOC操作 Bean 管理（xml 注入外部属性）
（1）创建两个类 service 类和 dao 类
（2）在 service 调用 dao 里面的方法
（3）在 spring 配置文件中进行配置
    public class UserService {
        //创建UserDao类型属性，生成set方法
        private UserDaoImpl userDao;
        public void setUserDao(UserDaoImpl userDao) {
            this.userDao = userDao;
        }
        public void add(){
            System.out.println("add...........");
            //原始调用方式:创建对象
            //UserDao userDao = new UserDaoImpl();
            //userDao.update();
            userDao.update();
        }
    }
     <!--serve和dao对象创建-->
        <bean id="userService" class="com.company.spring5.service.UserService">
            <!--注入userDao对象-->
            <property name="userDao" ref="userDaoImpl"></property>
        </bean>
        <bean id="userDaoImpl" class="com.company.spring5.dao.UserDaoImpl"></bean>
      
---------------------------------------------------------------------------------------------------------------------------
注入属性-内部bean和级联赋值
1.内部bean
<bean id="emp" class="com.company.spring5.bean.Emp">
    <property name="empName" value="张三"></property>
    <property name="gender" value="男"></property>
    <property name="dept">
        <bean id="dept" class="com.company.spring5.bean.Dept">
            <property name="deptName" value="售后部"></property>
        </bean>
    </property>
</bean>
2.级联赋值：
 方式1：
<bean id="emp" class="com.company.spring5.bean.Emp">
    <property name="empName" value="张三"></property>
    <property name="gender" value="男"></property>
    <!--设置对象类型属性-->
    <property name="dept" ref="dept"></property>
</bean>
<bean id="dept" class="com.company.spring5.bean.Dept">
    <property name="deptName" value="售后部"></property>
</bean>
方式2：
 <!--级联赋值：方式二-->
<bean id="emp" class="com.company.spring5.bean.Emp">
    <property name="empName" value="张三"></property>
    <property name="gender" value="男"></property>
    <!--设置对象类型属性,需要dept的get方法-->
    <property name="dept" ref="dept"></property>
    <property name="dept.deptName" value="财政部"></property>
</bean>
<bean id="dept" class="com.company.spring5.bean.Dept">
    <property name="deptName" value="售后部"></property>
</bean>

---------------------------------------------------------------------------------------------------------------------------
xml注入集合属性
1、注入数组类型属性
2、注入 List 集合类型属性
3、注入 Map 集合类型属性
4、注入 Set 集合类型属性

5.在集合里面设置对象类型值<br>
`<bean id="student" class="com.company.spring5.collectionType.Student">
    <!--注入数组集合类型-->
    <property name="courses">
        <array>
            <value>JavaEE课程</value>
            <value>钢铁是怎样炼成的</value>
        </array>
    </property>
    <!--注入list集合类型-->
    <property name="list">
        <list>
            <value>斗破苍穹</value>
            <value>死神永生</value>
        </list>
    </property>
    <!--注入map集合类型-->
    <property name="maps">
        <map>
            <entry key="白龙" value="海马"></entry>
            <entry key="黑龙" value="吹雪"></entry>
        </map>
    </property>
    <!--注入set集合类型-->
    <property name="sets">
        <set>
            <value>游泳</value>
            <value>蹦极</value>
        </set>
    </property>
    <!--注入 list 集合类型，值是对象-->
    <property name="courseList">
     <list>
     <ref bean="course1"></ref>
     <ref bean="course2"></ref>
     </list>
    </property>
</bean>`

6.把集合注入部分提取出来<br>
    （1）在 spring 配置文件中引入名称空间 util<br>
    ` <?xml version="1.0" encoding="UTF-8"?>
     <beans xmlns="http://www.springframework.org/schema/beans"
     xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     xmlns:util="http://www.springframework.org/schema/util"
     xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
                        http://www.springframework.org/schema/util  http://www.springframework.org/schema/util/spring-util.xsd">` <br>
    （2）使用 util 标签完成 list 集合注入提取<br>
       `<!--提取-->
       <util:list id="BookList">
              <value>鬼谷子</value>
              <value>易经</value>
              <value>论语</value>
       </util:list>
       <bean id="book" class="com.company.spring5.collectionType.Book">
              <property name="list" ref="BookList"></property>
       </bean>`
---------------------------------------------------------------------------------------------------------------------------
FactoryBean(工厂模式)<br>
Spring有两种类型的Bean,一种普通模式的bean,一种工厂模式的bean(FactoryBean)<br>
**普通 bean：在配置文件中定义 bean 类型就是返回类型**<br>
工厂 bean：在配置文件定义 bean 类型可以和返回类型不一样<br>
第一步 创建类，让这个类作为工厂 bean，实现接口 FactoryBean<br>
第二步 实现接口里面的方法，在实现的方法中定义返回的 bean 类型<br>
`public class MyBean implements FactoryBean{
    @Override
    public Object getObject() throws Exception {
        Course course = new Course();
        course.setCourseName("abc");
        return course;
    }
    @Override
    public Class<?> getObjectType() {
        return null;
    }
    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}`
`<bean id="myBean" class="com.company.spring5.factoryBean.MyBean"></bean>`
---------------------------------------------------------------------------------------------------------------------------
**IOC 操作 Bean 管理（bean 作用域）**<br>
1、在 Spring 里面，设置创建 bean 实例是单实例还是多实例<br>
2、在 Spring 里面，默认情况下，bean 是单实例对象<br>
![](E:\我的代码\Java学习项目\springFrameWork\spring5FrameWork\src\public\pictures\1673484922845_B3700CB9-FAC7-48c8-8046-A45D725FF72B.png)
**3、如何设置单实例还是多实例**<br>
（1）在 spring 配置文件 bean 标签里面有属性（scope）用于设置单实例还是多实例<br>
（2）scope 属性值<br>
   第一个值:默认值，singleton，表示是单实例对象<br>
   第二个值:prototype，表示是多实例对象<br>
`<bean id="book" class="com.company.spring5.collectionType.Book" scope="prototype">
<property name="list" ref="BookList"></property>
</bean>` <br>
![](E:\我的代码\Java学习项目\springFrameWork\spring5FrameWork\src\public\pictures\QQ截图20230112090329.png)
（3）singleton 和 prototype 区别<br>
 第一 singleton 单实例，prototype 多实例<br>
 第二 设置 scope 值是 singleton 时候，加载 spring 配置文件时候就会创建单实例对象。
 设置 scope 值是 prototype 时候，不是在加载 spring 配置文件时候创建对象，在调用
 getBean 方法时候创建多实例对象

---------------------------------------------------------------------------------------------------------------------------
**bean的生命周期**<br>
1.生命周期：从对象创建到对象销毁的过程<br>
2.bean生命周期<br>
(1)通过构造器创建bean实例(**无参构造函数**)<br>
(2)为bean的属性设置值和其他bean引用(调用set方法)<br>
(3)调用bean的初始化方法(需要进行配置初始化的方法)<br>
(4)bean可以使用了(对象成功创建了)<br>
(5)当容器关闭时，调用bean的销毁方法(需要进行配置销毁的方法)<br>
`public class Dept {
    private String deptName;
    public Dept() {
        System.out.println("第一步：通过构造函数创建bean实例");
    }
    public void setDeptName(String deptName) {
        this.deptName = deptName;
        System.out.println("第二步：调用set给bean的属性设置值");
    }
    @Override
    public String toString() {
        return "Dept{" +
                "deptName='" + deptName + '\'' +
                '}';
    }
    //初始化方法
    public void initDept(){
        System.out.println("第三步：调用Bean的初始化方法");
    }
    //销毁方法
    public void destroyMethod(){
        System.out.println("第五步：调用Bean的销毁方法");
    }
}` <br>
`@Test
public void testDept(){
    //ApplicationContext context = new ClassPathXmlApplicationContext("beanXml/beanBean.xml");
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanXml/beanLifeCycle.xml");
    Dept dept = context.getBean("dept",Dept.class);
    System.out.println("第四步：获取Bean创建的对象");
    System.out.println(dept);
    //手动销毁Bean实例
    //((ClassPathXmlApplicationContext)context).close();
    context.close();
}` <br>
3.bean的后缀处理器 ,bean的生命周期有7步<br>
（1）通过构造器创建 bean 实例（无参数构造）<br>
（2）为 bean 的属性设置值和对其他 bean 引用（调用 set 方法）<br>
**（3）把 bean 实例传递 bean 后置处理器的方法 postProcessBeforeInitialization** <br>
（4）调用 bean 的初始化的方法（需要进行配置初始化的方法）<br>
**（5）把 bean 实例传递 bean 后置处理器的方法 postProcessAfterInitialization** <br>
（6）bean 可以使用了（对象获取到了） <br>
（7）当容器关闭时候，调用 bean 的销毁的方法（需要进行配置销毁的方法） <br>
`public class MyBeanPost implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("在初始化之前执行的方法");
        return bean;
    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("在初始化之后执行的方法");
        return bean;
    }
}` <br>

---------------------------------------------------------------------------------------------------------------------------
xml自动装配<br>
`<bean id="emp" class="com.company.spring5.autowire.Emp" autowire="byName">
</bean>
<bean id="dept" class="com.company.spring5.autowire.Dept"></bean>`
---------------------------------------------------------------------------------------------------------------------------
IOC 操作 Bean 管理(外部属性文件)<br>
（1）配置德鲁伊连接池<br>
（2）引入德鲁伊连接池依赖 jar 包(druid-1.1.9.jar)<br>
<!--引入外部文件-->
xmlns:context="http://www.springframework.org/schema/context"
http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
<context:property-placeholder location="classpath:jdbc.properties"></context:property-placeholder>
<!--配置连接池-->
<bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
  <property name="driverClassName" value="${prop.driverClass}"></property>
  <property name="url" value="${prop.url}"></property>
  <property name="username" value="${prop.userName}"></property>
  <property name="password" value="${prop.passWord}"></property>
</bean>
---------------------------------------------------------------------------------------------------------------------------
基于注解方式实现
1.什么是注解？
(1).注解是代码特殊标记，格式@注解名称(属性名称-属性值，属性名称-属性值...)
(2).使用注解，注解作用在类，方法，属性上。
(3).使用注解目的：简化xml配置
2.Spring针对Bean管理中创建对象提供注解
(1)Component
(2)Service
(3)Control
(4)Repository
注:上面四个注解功能是一样的，都可以用来创建bean实例
3.基于注解方式实现对象创建
第一步:引入注解依赖 spring-aop-5.2.6.RELEASE.jar
第二步:开启组件扫描
<!--1.如果扫描多个包，多个包用逗号隔开，2.扫描包上层目录-->
<context:component-scan base-package="com.company.spring5"></context:component-scan>
第三步:创建类，在类上面添加创建对象注释
在注解里面 value 属性值可以省略不写，
默认值是类名称，首字母小写
UserService -- userService
4.开启组件扫描细节配置
<!--示例 1use-default-filters="false" 表示现在不使用默认 filter，自己配置 filter context:include-filter ，设置扫描哪些内容-->
<context:component-scan base-package="com.atguigu" use-defaultfilters="false">
 <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
</context:component-scan>
<!--示例 2下面配置扫描包所有内容context:exclude-filter： 设置哪些内容不进行扫描-->
<context:component-scan base-package="com.atguigu">
 <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
</context:component-scan>
5.基于注解方式实现属性注入
(1)@Autowired:根据属性类型进行自动装配
第一步 把 service 和 dao 对象创建，在 service 和 dao 类添加创建对象注解
第二步 在 service 注入 dao 对象，在 service 类添加 dao 类型属性，在属性上面使用注解
(2)@Qualifier:根据名称进行自动装配，这个@Qualifier 注解的使用，和上面@Autowired 一起使用
(3)@Resource:可以根据类型注入，也可以根据名称注入
//@Resource //根据类型进行注入
@Resource(name = "userDaoImpl1") //根据名称进行注入
private UserDao userDao;
(4)@Value:注入普通类型属性
@Value(value = "abc")
private String name;
6.完全注解开发
（1）创建配置类，替代 xml 配置文件
@Configuration //作为配置类，替代xml文件
@ComponentScan(basePackages = {"com.company"})
public class SpringConfig {
}
（2）编写测试类
ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
UserService userServices = context.getBean("userService", UserService.class);
System.out.println(userServices);
userServices.add();

---------------------------------------------------------------------------------------------------------------------------
