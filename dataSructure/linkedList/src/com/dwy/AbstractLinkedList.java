package com.dwy;

import com.dwy.exception.IndexOutOfRangeException;

/**
 * @Author: DongWenYu
 * @Date: 2021/6/14 17:51
 */
public abstract class AbstractLinkedList<T> implements LinkedList<T> {

    /**
     * 头指针
     */
    private Node<T> head;

    @Override
    public  void add(T item){
        add(item,getSize());
    };

    @Override
    public void add(T item, Integer index) {
        try {
            checkIndexBeforeAdd(index);

            if (!firstAdd(item)) {
                if (index == 0) {
                    addHead(item);
                } else {
                    addMid(index, item);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ;

    @Override
    public T get(Integer index) {
        Node<T> node = getNode(index);
        if (node == null){
            return null;
        }else {
            return node.item;
        }
    }

    @Override
    public  void remove(Integer index){
        try {
            IndexOutOfRange(index);

            //删除头节点的情况
            if (index.equals(0)) {
                removeHead();
            } else {
                removeMid(index);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    };

    /**
     * 获得指定位置的node节点
     * @param index 指定位置
     * @return com.dwy.AbstractLinkedList.Node<T>
     * @create 2021/6/14 18:06
     */
    protected abstract Node<T> getNode(Integer index);

    /**
     * 检查当前位置是否越界
     * @param index 当前位置
     * @return java.lang.Boolean
     * @create 2021/6/14 18:22
     */
    protected void IndexOutOfRange(Integer index) throws IndexOutOfRangeException {
        if (index >= getSize() || index < 0){
            throw new IndexOutOfRangeException();
        }
    }


    /**
     * 第一次添加
     * @param item 添加对象
     * @return Boolean
     * @create 2021/6/14 20:49
     */
    protected abstract Boolean firstAdd(T item);

    /**
     * 删除中间指定位置的节点
     * @param index 指定位置
     * @return void
     * @create 2021/6/14 21:14
     */
    protected abstract void removeMid(Integer index);

    /**
     * 插入头结点
     * @param item
     * @return void
     * @create 2021/6/14 21:00
     */
    protected abstract void addHead(T item);

    /**
     * 在插入前检查下界
     * @param index
     * @return void
     * @create 2021/6/14 21:00
     */
    protected void checkIndexBeforeAdd(Integer index) throws IndexOutOfRangeException{
        if (index > getSize()){
            throw new IndexOutOfRangeException();
        }
    }

    protected abstract void addMid(Integer index, T item);

    protected abstract void removeHead();

    protected abstract Integer getSize();

    /**
     * 将对象转化为node节点
     * @param <T>
     */
    protected abstract static class Node<T> {
        /**
         * 对象
         */
        protected T item;

        public Node(T item) {
            this.item = item;
        }

        @Override
        public String toString() {
            return String.valueOf(item);
        }
    }
}
