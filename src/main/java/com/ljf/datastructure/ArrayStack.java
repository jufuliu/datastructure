package com.ljf.datastructure;

/**
 * @author liujufu
 * @date 2019/2/28 15:57
 */
public class ArrayStack<E> implements Stack<E> {
    private Array<E> array;

    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayStack(){
        this(10);
    }

    public void push(E e){
        array.addLast(e);
    }

    public E pop(){
        return array.removeLast();
    }

    public E peek(){
        return array.getLast();
    }

    public int getSize(){
        return array.getSize();
    }

    public boolean isEmpty(){
        return array.isEmpty();
    }
    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("ArrayStack size=%s,capacity=%s,[",array.getSize(),array.getCapacity()));
        for(int i=0;i<array.getSize();i++){
            sb.append(array.get(i));
            if(i<array.getSize()-1){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
