package com.fang.dailytask.factoryPattern;

/**
 * Author: fangxueshun
 * Description: 最大子序列求和
 * Date: 2017/3/6
 * Time: 23:38
 */
public class ProductA implements ProductInf {

    @Override
    public String  productMethod(){
        System.out.printf("这是产品A的实现");
        return "这是产品A的实现";
    }
}
