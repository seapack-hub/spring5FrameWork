package com.company.spring5.AOP.aspectJ;/**
 * @author haifeng.zeng
 * @date 2023/2/7
 * @time 19:18
 * @package_name com.company.spring5.AOP.aspectJ
 * @project_name spring5FrameWork
 */

import org.springframework.stereotype.Component;

/**
 *注释
 *
 *@author: haifeng.zeng
 *@date: 2023/2/7
 */
@Component
public class User {
    public void add(int a,int b){
        int c = a+b;
        System.out.println("计算结果："+c);
    }
}
