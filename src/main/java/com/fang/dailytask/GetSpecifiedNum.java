package com.fang.dailytask;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Author: fangxueshun
 * Description: 获取无序数组中第k大的数,相同数字默认为排序相同
 * Date: 2017/3/7
 * Time: 23:40
 */
public class GetSpecifiedNum {

    public int specifiedNum(List<Integer> numbers, int point) {
        int specifiedNum = 0;
        if (numbers.isEmpty() || point < 1||numbers.size()<point)
            return 0;
        //去重
        numbers = new ArrayList<>(new HashSet<>(numbers));
        //冒泡排序
        for (int i = 0; i < numbers.size(); i++) {
            int var1 = numbers.get(i);
            for(int j=i+1;j<numbers.size();j++){
                int var2 = numbers.get(j);
                if(var1<var2){
                    numbers.set(i,var2);
                    numbers.set(j,var1);
                    var1=var2;
                }
            }
        }
        specifiedNum = numbers.get(point-1);
        return specifiedNum;
    }
}
