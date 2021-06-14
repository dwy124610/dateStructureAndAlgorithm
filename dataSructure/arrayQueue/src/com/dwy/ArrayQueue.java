package com.dwy;

/**
 * @Author: DongWenYu
 * @Date: 2021/5/30 20:45
 */
public class ArrayQueue {

    /**
     * 最大容量
     */
    private int maxSize = 0;

    /**
     * 前指针
     */
    private int front = 0;

    /**
     * 后指针
     */
    private int rear = 0;

    /**
     * 内部数组
     */
    private Object[] array;

    /**
     * 向队列中添加
     * @param item 添加的对象
     * @return void
     * @create 2021/5/30 20:53
     */
    public void add(Object item) {
        //当前队列满则无法添加，抛出异常
        if (isFull()){
            new Exception("当前队列已满").printStackTrace();
        }
        array[rear-front] = item;
        rear++;
    }

    /**
     * 取出队列中的第一个对象
     * @return void
     * @create 2021/5/30 20:53
     */
    public Object remove() {
        //当前队列满则无法添加，抛出异常
        if (isEmpty()){
            new Exception("当前队列为空").printStackTrace();
        }
        front++;
        return array[front-1];
    }

    /**
     * 查看队列中的第一个对象
     * @return void
     * @create 2021/5/30 20:53
     */
    public Object head() {
        //当前队列满则无法添加，抛出异常
        if (isEmpty()){
            new Exception("当前队列为空").printStackTrace();
        }
        return array[front];
    }

    //判断队列是否满
    public boolean isFull() {
        return rear - front >= maxSize;
    }
    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    public void show(){
        System.out.printf("array:" );
        for (int i = front % maxSize ; i < front % maxSize + rear - front; i++ ){
            System.out.printf("%d",array[i]);
        }
        System.out.println();
    }

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.array = new Object[maxSize];
    }


    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int getRear() {
        return rear;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }

    public Object[] getArray() {
        return array;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }

}
