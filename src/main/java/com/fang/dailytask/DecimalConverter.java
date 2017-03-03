package com.fang.dailytask;

import java.util.Stack;

/**
 * Author: fangxueshun
 * Description: 使用栈，将十进制整数转换为任意进制
 * Date: 2017/3/3
 * Time: 22:42
 */
public class DecimalConverter {

    /**
     * @param decimalNum 十进制数字，如100
     * @param scale      进制位数，如3进制，4进制，则分别传入3或4
     */
    public String converter(int decimalNum, int scale) {
        String targetStr = "";
        Stack stack = new Stack();
        while (true) {
            if (decimalNum < scale) {
                stack.push(decimalNum);
                break;
            } else {
                stack.push(decimalNum % scale);
                decimalNum = decimalNum / scale;
            }
        }
        int time = stack.size();
        /*！！！注意，循环不可写成for(int i =0;i<stack.size();i++)！！！*/
        for(int i =0;i<time;i++){
            int popNum = (int)stack.pop();
            targetStr=targetStr+popNum;
        }
        return targetStr;
    }

}
