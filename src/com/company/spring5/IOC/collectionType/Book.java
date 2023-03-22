package com.company.spring5.IOC.collectionType;/**
 * @author haifeng.zeng
 * @date 2023/1/10
 * @time 11:29
 * @package_name com.company.spring5.IOC.collectionType
 * @project_name spring5FrameWork
 */

import java.util.List;

/**
 *注释
 *
 *@author: haifeng.zeng
 *@date: 2023/1/10
 */
public class Book  {

    private List<String> list;

    public void setList(List<String> list) {
        this.list = list;
    }

    public void test(){
        System.out.println(list);
    }
}
