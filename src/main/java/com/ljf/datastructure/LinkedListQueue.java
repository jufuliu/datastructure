package com.ljf.datastructure;

/**
 * @author liujufu
 * @date 2019/3/8 14:32
 */
public class LinkedListQueue<E> implements Queue<E> {

    LinkedList<E> list;

    public LinkedListQueue(){
        this.list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        list.addLast(e);
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        return list.removeFirst();
    }

    @Override
    public E getFront() {
        return list.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(list);
        return sb.toString();
    }
}
