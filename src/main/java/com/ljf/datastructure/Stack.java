package com.ljf.datastructure;

/**
 * @author liujufu
 * @date 2019/3/4 17:43
 */
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
