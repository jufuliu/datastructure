package com.ljf.datastructure;

/**
 * @author liujufu
 * @date 2019/2/20 10:27
 */
public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e=e;
            this.next=next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList(){
        this.dummyHead=new Node();
        this.size=0;
    }

    public void add(int index,E e){
        if(index<0 || index>size){
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node prev = dummyHead;
        for(int i=0;i<index;i++){
            prev = prev.next;
        }
        prev.next = new Node(e,prev.next);
        size++;
    }

    public void addFirst(E e){
        add(0,e);
    }

    public void addLast(E e){
        add(size,e);
    }

    public E remove(int index){
        if(index<0 || index>size){
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node prev = dummyHead;
        for(int i=0;i<index;i++){
            prev = prev.next;
        }
        Node node = prev.next;
        prev.next = node.next;
        node.next=null;
        size--;
        return node.e;
    }

    public void removeElement(E e){

        Node prev = dummyHead;
        while (prev.next!=null){
            if(prev.next.e.equals(e)){
                Node mv = prev.next;
                if(mv!=null){
                    prev.next = mv.next;
                    mv.next=null;
                    size--;
                    break;
                }
            }
            prev = prev.next;
        }
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    public void set(int index,E e){
        if(index<0 || index>size){
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for(int i=0;i<index;i++){
            cur = cur.next;
        }
        cur.e=e;
    }

    public E get(int index){
        Node cur = dummyHead.next;
        for(int i=0;i<index;i++){
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst(){
        return get(0);
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("LinkedList size=%s,[",getSize()));
        Node cur = dummyHead.next;
        while (cur !=null){
            sb.append(cur.e);
            cur=cur.next;
            sb.append("->");
        }
        sb.append("NULL");
        sb.append("]");
        return sb.toString();
    }

}
