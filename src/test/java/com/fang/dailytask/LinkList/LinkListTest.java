package com.fang.dailytask.LinkList;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Author: fangxueshun
 * Description: 测试单链表
 * Date: 2017/3/6
 * Time: 18:25
 */
public class LinkListTest {

    /*创建链表*/
    @Test
    public final void TestLinkList(){
        LinkList linkList = new LinkList();
        linkList.add(1);
        linkList.add(2);
        linkList.add(3);
        linkList.add(4);
        assertEquals("LinkList:1 2 3 4 ",linkList.toString());

    }
}