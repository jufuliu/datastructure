package com.ljf.datastructure;

/**
 * @author liujufu
 * @date 2019/2/28 16:11
 */
public class ArrayQueue<T> {
    private Array<T> array;

    public ArrayQueue(int capacity){
        array=new Array<>(capacity);
    }

    public ArrayQueue(){
        this(10);
    }

    public void enqueue(T e){
        array.addFirst(e);
    }

    public void dequeue(){
        array.removeLast();
    }

    public T getFront(){
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
        sb.append(String.format("ArrayQueue size=%s,capacity=%s,tail[",array.getSize(),array.getCapacity()));
        for(int i=0;i<array.getSize();i++){
            sb.append(array.get(i));
            if(i<array.getSize()-1){
                sb.append(",");
            }
        }
        sb.append("]front");
        return sb.toString();
    }
}
