package com.dwy;

import com.dwy.exception.IndexOutOfRangeException;

/**
 * @Author: DongWenYu
 * @Date: 2021/6/15 14:30
 */
public class CircleLinkedList<T> extends AbstractLinkedList<T>{

    /**
     * 头结点
     */
    private Node<T> head ;

    /**
     * 将对象转化为node节点
     * @param <T>
     */
    public static class Node<T> extends AbstractLinkedList.Node<T> {

        /**
         * 指向下一个node节点的指针
         */
        protected Node<T> next;

        public Node(T item) {
            super(item);
        }
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
    protected Boolean firstAdd(T item) {
        if (head == null){
            head = new Node(item);
            return true;
        }
        return false;
    }

    @Override
    protected void removeMid(Integer index) {
        Node<T> preNode = getNode(index - 1);
        preNode.next = preNode.next.next;
    }

    @Override
    protected void addHead(T item) {
        Node<T> itemNode = new Node<>(item);
        Node<T> end = getNode(getSize() - 1);
        end.next = itemNode;
        itemNode.next = head;
        head = itemNode;
    }

    @Override
    protected void addMid(Integer index, T item) {
        //单向链表插入时需要找到前一个节点
        Node<T> itemNode = new Node<>(item);
        Node<T> preNode = getNode(index - 1);
        itemNode.next = preNode.next;
        preNode.next = itemNode;
    }

    @Override
    protected void removeHead() {
        Node<T> end = getNode(getSize() - 1);
        head = head.next;
        end.next = head;
    }

    @Override
    protected Integer getSize() {
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

    @Override
    public String toString() {
        String str = "";
        Node<T> temp = head;
        Node<T> end = getNode(getSize()-1);
        while (temp != end){
            str = str.concat(temp.toString()).concat("->");
            temp = temp.next;
        }
        return str.concat(temp.toString()).concat("->");
    }

    public Node<T> getHead() {
        return head;
    }

}
