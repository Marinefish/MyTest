package com.fang.dailytask;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Author: fangxueshun
 * Description: 获取无序数组中第k大的数,相同数字默认为排序相同
 * Date: 2017/3/8
 * Time: 0:18
 */
public class GetSpecifiedNumTest {

    @Test
    public void specifiedNum() throws Exception {
        GetSpecifiedNum getSpecifiedNum = new GetSpecifiedNum();
        List<Integer> testNums1 = new ArrayList<>();
        List<Integer> testNums2 = new ArrayList<>();
        testNums1.add(1);
        testNums1.add(3);
        testNums1.add(4);
        testNums1.add(6);
        testNums1.add(8);
        testNums2.add(3);
        testNums2.add(1);
        testNums2.add(8);
        testNums2.add(6);
        testNums2.add(4);
        assertEquals(1,getSpecifiedNum.specifiedNum(testNums1,5));
        assertEquals(4,getSpecifiedNum.specifiedNum(testNums1,3));
        assertEquals(8,getSpecifiedNum.specifiedNum(testNums1,1));
        assertEquals(1,getSpecifiedNum.specifiedNum(testNums2,5));
        assertEquals(4,getSpecifiedNum.specifiedNum(testNums2,3));
        assertEquals(8,getSpecifiedNum.specifiedNum(testNums2,1));
    }

}