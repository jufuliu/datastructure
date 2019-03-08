package com.ljf.datastructure;

/**
 * @author liujufu
 * @date 2019/3/8 15:08
 */
public class BST<E extends Comparable<E>> {
    private class Node{
        E e;
        Node left;
        Node right;
        public Node(E e){
            this.e=e;
            this.left=null;
            this.right=null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size=0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }
}
