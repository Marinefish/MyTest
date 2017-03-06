package com.fang.dailytask.factoryPattern;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Author: fangxueshun
 * Description: 工厂方法测试
 * Date: 2017/3/6
 * Time: 23:45
 */
public class FactoryTest {

    @Test
    public final void testFactory(){
        ProductInf productInf = new Factory().createProduct();
        assertEquals("这是产品A的实现",productInf.productMethod());

    }
}