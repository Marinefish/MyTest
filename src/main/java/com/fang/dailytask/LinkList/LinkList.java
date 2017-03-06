package com.fang.dailytask.LinkList;

/**
 * Author: fangxueshun
 * Description: 实现单链表(只接收int类型)
 * Date: 2017/3/6
 * Time: 18:12
 */
public class LinkList {
    public Node head;//头节点
    public Node current;//当前节点

    public void add(int data) {
        if (head == null) {
            head = new Node(data);
            current = head;
        } else {
            current.next = new Node(data);
            current = current.next;
        }
    }

    public String toString() {
        Node temp = head;
        String str = "LinkList:";
        while (temp != null) {
            str = str + temp.data + " ";
            temp= temp.next;
        }
        return str;
    }

    /*节点*/
    class Node implements Cloneable {
        int data;//数据域
        Node next;//指针域，下个节点

        public Node(int data) {
            this.data = data;
        }

        @Override
        public Node clone() {
            Node node = null;
            try {
                node =(Node)super.clone();
            }catch (CloneNotSupportedException e){
                e.printStackTrace();
            }
            return node;
        }
    }
}
