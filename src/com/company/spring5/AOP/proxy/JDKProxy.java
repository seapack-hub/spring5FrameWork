package com.company.spring5.AOP.proxy;/**
 * @author haifeng.zeng
 * @date 2023/2/3
 * @time 12:25
 * @package_name com.company.spring5.AOP.proxy
 * @project_name spring5FrameWork
 */

import com.company.spring5.AOP.UserDao;
import com.company.spring5.AOP.UserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 *注释
 *
 *@author: haifeng.zeng
 *@date: 2023/2/3
 */
public class JDKProxy {
    public static void main(String[] args) {

        //创建接口实现代理类对象
        Class[] interfaces = {UserDao.class};

        UserDaoImpl userDao = new UserDaoImpl();

        UserDao dao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(),interfaces,new UserDaoProxy(userDao));
        int result = dao.add(1,2);
        System.out.println("result:"+result);
    }
}

//创建代理对象代码
class UserDaoProxy implements InvocationHandler {

    //1 把创建的是谁的代理对象，把谁传递过来
    //有参数构造传递
    private Object object;
    public UserDaoProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法之前执行;"+method.getName());
        System.out.println("传递的参数："+ Arrays.toString(args));
        Object res = method.invoke(object,args);
        return res;
    }
}
