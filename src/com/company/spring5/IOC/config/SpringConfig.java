package com.company.spring5.IOC.config;/**
 * @author haifeng.zeng
 * @date 2023/1/31
 * @time 18:01
 * @package_name com.company.spring5.IOC.config
 * @project_name spring5FrameWork
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *注释
 *
 *@author: haifeng.zeng
 *@date: 2023/1/31
 */
@Configuration //作为配置类，替代xml文件
@ComponentScan(basePackages = {"com.company"})
public class SpringConfig {
}
