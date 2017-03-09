package com.fang.dailytask;

import java.util.Arrays;
import java.util.Collections;

/**
 * Author: fangxueshun
 * Description: 英文字符串反转
 *
 * @see "https://leetcode.com/problems/reverse-words-in-a-string/?tab=Description"
 * Date: 2017/3/9
 * Time: 23:24
 */
public class WordsReverse {

    public String reverse(String s) {
//        String[] words = s.split(" ");
//        String target = "";
//        int length = words.length;
//        if(length==2)
//            return s.replace(" ","");
//        for (int i = 0; i < length; i++) {
//            target = (i != length - 1) ? target + words[length - i - 1] + " " :
//                    target + words[length - i - 1];
//
//        }
//        return target;
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

}
