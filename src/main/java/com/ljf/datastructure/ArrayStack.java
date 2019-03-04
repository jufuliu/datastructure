package com.ljf.datastructure;

/**
 * @author liujufu
 * @date 2019/2/28 15:57
 */
public class ArrayStack<T> {
    private Array<T> array;

    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayStack(){
        this(10);
    }

    public void push(T e){
        array.addLast(e);
    }

    public void pop(){
        array.removeLast();
    }

    public T peek(){
        return array.getLast();
    }

    public int getSize(){
        return array.getSize();
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
