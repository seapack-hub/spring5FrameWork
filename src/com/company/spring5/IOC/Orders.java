package com.company.spring5.IOC;/**
 * @author haifeng.zeng
 * @date 2023/1/6
 * @time 17:33
 * @package_name com.company.spring5
 * @project_name spring5FrameWork
 */

/**
 *注释
 *
 *@author: haifeng.zeng
 *@date: 2023/1/6
 */
public class Orders {
    //属性
    private String orderName;
    private String address;
    //有参数构造
    public Orders(String orderName,String address) {
        this.orderName = orderName;
        this.address = address;
    }

    public void OrderTest(){
        System.out.println(orderName+":"+address);
    }
}
