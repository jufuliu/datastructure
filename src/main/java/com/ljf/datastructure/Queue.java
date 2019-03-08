package com.ljf.datastructure;

/**
 * @author liujufu
 * @date 2019/3/4 17:43
 */
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();

}
