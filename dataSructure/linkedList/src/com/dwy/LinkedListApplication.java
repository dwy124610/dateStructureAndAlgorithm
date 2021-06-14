package com.dwy;

/**
 * @Author: DongWenYu
 * @Date: 2021/6/14 19:39
 */
public class LinkedListApplication {
    public static void main(String[] args) {
//        LinkedList<Integer> singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(1);
//        singleLinkedList.add(2);
//        singleLinkedList.add(3);
//        singleLinkedList.add(4,1);
//        System.out.println(singleLinkedList.toString());
//        System.out.println(singleLinkedList.get(1));
//       singleLinkedList.remove(1);
//       System.out.println(singleLinkedList.toString());
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.add(1);
        doubleLinkedList.add(2);
        doubleLinkedList.add(3);
        doubleLinkedList.add(4,1);
        doubleLinkedList.remove(1);
        System.out.println(doubleLinkedList.toString());
    }
}
