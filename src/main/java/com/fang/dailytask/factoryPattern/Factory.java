package com.fang.dailytask.factoryPattern;

/**
 * Author: fangxueshun
 * Description: 最大子序列求和
 * Date: 2017/3/6
 * Time: 23:42
 */
public class Factory implements FactoryInf {
    @Override
    public ProductInf createProduct() {
        return new ProductA();
    }
}
