package com.company.spring5.AOP.aspectJ;/**
 * @author haifeng.zeng
 * @date 2023/2/8
 * @time 12:20
 * @package_name com.company.spring5.AOP.aspectJ
 * @project_name spring5FrameWork
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *注释
 *完全注解开发，配置类
 *@author: haifeng.zeng
 *@date: 2023/2/8
 */
@Configuration
@ComponentScan(basePackages = {"com.company.spring5.AOP.aspectJ"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop {
}
