package com.dwy;

/**
 * @Author: DongWenYu
 * @Date: 2021/5/30 20:44
 */
public class ArrayQueueApplication {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.add(1);
        arrayQueue.show();
        arrayQueue.add(2);
        arrayQueue.show();
        arrayQueue.add(3);
        arrayQueue.show();
//        arrayQueue.add(4);
//        System.out.println(arrayQueue.toString());
        arrayQueue.remove();
        arrayQueue.show();
        arrayQueue.remove();
        arrayQueue.show();
        arrayQueue.remove();
        arrayQueue.show();
        arrayQueue.remove();
        arrayQueue.show();
    }
}
