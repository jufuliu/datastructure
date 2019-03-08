package com.ljf.datastructure;

/**
 * @author liujufu
 * @date 2019/2/24 19:10
 */
public class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity){
        data = (E[])new Object[capacity];
        size=0;
    }

    public Array(){
        this(10);
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void add(int index,E e){

        if(index<0 || index>size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size");
        }
        if(size==data.length){
            resize(data.length*2);
        }
        for(int i=size-1;i>=index;i--){
            data[i+1]=data[i];
        }
        data[index]=e;
        size++;
    }

    public void resize(int newCapacity){
        E[] arr =(E[])new Object[newCapacity];
        for(int i=0;i<size;i++){
            arr[i]=data[i];
        }
        data=arr;
    }

    public void addFirst(E e){
        add(0,e);
    }

    public void addLast(E e){
        add(size,e);
    }

    public E get(int index){
        if(index<0 || index>=size){
            throw new IllegalArgumentException("Index is illegal");
        }
        return data[index];
    }

    public E getLast(){
        return get(size-1);
    }

    public void set(int index,E e){
        if(index<0 || index>=size){
            throw new IllegalArgumentException("Index is illegal");
        }
        data[index]=e;
    }

    public boolean contains(E e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    public int find(E e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    public E remove(int index){
        if(index<0 || index>=size){
            throw new IllegalArgumentException("Index is illegal");
        }
        E e= data[index];
        for(int i=index;i<size-1;i++){
            data[i]=data[i+1];
        }
        size--;
        if(size==data.length/4 && data.length/2!=0){
            resize(data.length/2);
        }
        return e;
    }

    public E removeLast(){
        return remove(size-1);
    }

    public void removeElement(E e){
        int index = find(e);
        if(index!=-1){
            remove(index);
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array size=%s,capacity=%s,[",size,data.length));
        for(int i=0;i<size;i++){
            sb.append(data[i]);
            if(i<size-1){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
