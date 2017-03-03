package com.fang.dailytask;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Author: fangxueshun
 * Description:十进制整数转换为任意进制测试
 * Date: 2017/3/3
 * Time: 23:00
 */
public class DecimalConverterTest {

    @Test
    /*三进制测试*/
    public void converterernary() throws Exception {
        DecimalConverter decimalConverter = new DecimalConverter();
        assertEquals("22",decimalConverter.converter(8,3));
        assertEquals("2",decimalConverter.converter(2,3));
        assertEquals("1000",decimalConverter.converter(27,3));
    }

    @Test
    /*二进制测试*/
    public void converBinary() throws Exception {
        DecimalConverter decimalConverter = new DecimalConverter();
        assertEquals("1000",decimalConverter.converter(8,2));
        assertEquals("1",decimalConverter.converter(1,2));
        assertEquals("10000",decimalConverter.converter(16,2));
    }

}