package com.fang.dailytask;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Author: fangxueshun
 * Description: leetcod "twosum" testcase
 * Date: 2017/3/8
 * Time: 23:29
 */
public class TwoSumSolutionTest {

    @Test
    public final void testSolution(){
        int [] expect = {0,1};
        TwoSumSolution twoSumSolution = new TwoSumSolution();
        int [] nums = {2, 7, 11, 15};
        assertArrayEquals(expect,twoSumSolution.twoSum(nums,9));
        assertArrayEquals(expect,twoSumSolution.twoSumQuick(nums,9));
    }
}