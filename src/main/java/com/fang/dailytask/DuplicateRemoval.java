package com.fang.dailytask;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Author: fangxueshun
 * Description: 使用HashSet快速去重
 * Date: 2017/3/2
 * Time: 23:03
 */
public class DuplicateRemoval {

    public List removalDup(List list){
        return new ArrayList(new HashSet(list));
    }

}
