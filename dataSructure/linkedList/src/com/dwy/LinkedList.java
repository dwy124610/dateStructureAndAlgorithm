package com.dwy;

/**
 * @Author: DongWenYu
 * @Date: 2021/6/14 17:51
 */
public interface LinkedList<T> {

    /**
     * 向链表尾部添加对象
     * @param item 对象
     * @return void
     * @create 2021/6/14 17:55
     */
    public void add(T item);

    /**
     * 向链表指定位置后添加对象
     * @param item 对象
     * @param index 指定位置
     * @return void
     * @create 2021/6/14 17:55
     */
    public void add(T item , Integer index);

    /**
     * 得到指定位置的对象
     * @param index 指定位置
     * @return T
     * @create 2021/6/14 17:56
     */
    public T get(Integer index);

    /**
     * 删除指定位置的对象
     * @param index 指定位置
     * @return void
     * @create 2021/6/14 17:57
     */
    public void remove(Integer index);

}
