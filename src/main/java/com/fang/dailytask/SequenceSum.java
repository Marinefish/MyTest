package com.fang.dailytask;

/**
 * Author: fangxueshun
 * Description: 最大子序列求和
 * Date: 2017/3/1
 * Time: 19:29
 */
public class SequenceSum {
    public int sum(int[] sequence) {
        int pointerFirst = 0;
        int pointerLast = 0;
        boolean hasPositiveNum = false;
        for (int element : sequence) {
            if (element > 0) {
                hasPositiveNum = true;
            }
        }
        if (sequence.length == 0 || !hasPositiveNum)
            return 0;
        int maxSum = 0;
        for (int i = 0; i < sequence.length; i++) {
            int tempSum = sequence[i];
            for (int j = i + 1; j < sequence.length; j++) {
                tempSum = tempSum + sequence[j];
                if (tempSum > maxSum) {
                    maxSum = tempSum;
                    pointerFirst = i;
                    pointerLast = j;
                }
            }
        }
        String maxSumStr = "";
        for (int i = pointerFirst; i <= pointerLast; i++){
            maxSumStr=maxSumStr+sequence[i]+",";
        }
            System.out.println("序列--"+getSequenceStr(sequence)+"最大子序列为: "+maxSumStr);
        return maxSum;
    }
    public String getSequenceStr(int[] sequence){
        String str="";
        for(int i=1;i<sequence.length+1;i++){
            if(i==sequence.length){
                str+=sequence[i-1];
            }else {
                str+=sequence[i-1]+",";
            }

        }
        return str;
    }
}
