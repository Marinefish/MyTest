package com.fang.dailytask;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: fangxueshun
 * Description: leetcod "twosum"
 *
 * @see https://leetcode.com/problems/two-sum/
 * Date: 2017/3/8
 * Time: 23:26
 */


public class TwoSumSolution {

    /*时间复杂度（O(n²)的解法*/
    public int[] twoSum(int[] nums, int target) {
        int[] solution = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int firstNum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int secondNum = nums[j];
                int sum = firstNum + secondNum;
                if (sum == target) {
                    solution[0] = i;
                    solution[1] = j;
                }
            }
        }
        return solution;
    }

    /*时间复杂度（O(n)的解法*/
    public int[] twoSumQuick(int[] nums, int target) {
        int[] solution = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                solution[0]=map.get(target-nums[i]);
                solution[1]=i;
            }else {
                map.put(nums[i],i);
            }
        }
        return solution;
    }
}

