package com.dwy;

import com.dwy.exception.IndexOutOfRangeException;

/**
 * @Author: DongWenYu
 * @Date: 2021/6/14 17:36
 */
public class DoubleLinkedList<T> extends AbstractLinkedList<T>{


    protected Node<T> head ;

    @Override
    public Integer getSize() {
        int size = 0;
        Node<T> temp = head;
        if (temp == null){
            return 0;
        }
        while (temp.next != null){
            size ++;
            temp = temp.next;
        }
        return size+1;
    }

    /**
     * 将对象转化为node节点
     * @param <T>
     */
    private static class Node<T> extends AbstractLinkedList.Node<T> {

        /**
         * 指向上一个node节点的指针
         */
        private Node<T> pre;

        /**
         * 指向下一个node节点的指针
         */
        protected Node<T> next;

        public Node(T item) {
            super(item);
        }
    }


    @Override
    protected void addHead(T item) {
        Node<T> itemNode = new Node<>(item);
        itemNode.next = head;
        head.pre = itemNode;
    }

    @Override
    protected void addMid(Integer index, T item){
        Node<T> itemNode = new Node<>(item);
        Node<T> preNode = getNode(index - 1);
        if (preNode.next != null){
            Node<T> nextNode = getNode(index);
            nextNode.pre = itemNode;
            itemNode.next = nextNode;
        }
        preNode.next = itemNode;
        itemNode.pre = preNode;
    }

    @Override
    protected void removeHead() {
        head = head.next;
        head.pre = null;
    }

    @Override
    protected void removeMid(Integer index){
        Node<T> removeNode = getNode(index);
        removeNode.pre.next = removeNode.next;
    }

    @Override
    protected Node<T> getNode(Integer index) {
        try {
            IndexOutOfRange(index);
            Node<T> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } catch (IndexOutOfRangeException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected Boolean firstAdd(T item){
        if (head == null){
            head = new Node(item);
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        String str = "";
        Node<T> temp =  head;
        while (temp.next != null){
            str = str.concat(temp.toString()).concat("->");
            temp = temp.next;
        }
        return str.concat(temp.toString());
    }
}
