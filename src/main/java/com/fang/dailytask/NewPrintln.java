package com.fang.dailytask;

import java.io.PrintStream;

/**
 * Author: fangxueshun
 * Description: 重写pringtln方法,使逗号两边的字符串交换位置
 * Date: 2017/3/10
 * Time: 23:49
 */
public class NewPrintln {

    public void myPrintln() {
        PrintStream printStream = new PrintStream(System.out) {
            @Override
            public void println(String s) {
                 if(s.contains(",")){
                     String[] var = s.split(",");
                     if(var.length==2){
                         s = var[1]+","+var[0];
                     }
                 }
                 super.println(s);
            }
        };
        System.setOut(printStream);
    }
}
