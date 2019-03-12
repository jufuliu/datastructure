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

    public void add(E e){
        root= add(root,e);
    }
//  在以node 为根节点出插入元素
//    private void add(Node node,E e){
//        if(e.equals(node.e)){
//            return;
//        }
//        if(e.compareTo(node.e)<0 && node.left==null){
//            node.left = new Node(e);
//            return;
//        }else if(e.compareTo(node.e)>0 && node.right==null){
//            node.right = new Node(e);
//            return;
//        }
//        if(e.compareTo(node.e)<0){
//            add(node.left,e);
//        }else if(e.compareTo(node.e)>0){
//            add(node.right,e);
//        }
//    }

    //  在以node 为根节点出插入元素
    private Node add(Node node,E e){
        if(node==null){
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e)<0){
            node.left=add(node.left,e);
        }else if(e.compareTo(node.e)>0){
            node.right = add(node.right,e);
        }
        return node;
    }
    public boolean contains(E e){
        return contains(root,e);
    }

    private boolean contains(Node node,E e){
        if(node==null){
            return false;
        }
        if(e.compareTo(node.e)==0){
            return true;
        }else if(e.compareTo(node.e)<0){
            return contains(node.left,e);
        }else {
            return contains(node.right,e);
        }
    }
    //    前序遍历
    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if(node==null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }
//    前序遍历非递归实现
    public void preOrderRN(){
        if(root==null) return;
        Stack<Node> stack=new ArrayStack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            System.out.println(node.e);
            if(node.right!=null)
                stack.push(node.right);
            if(node.left!=null)
                stack.push(node.left);
        }
    }
    //    中序遍历
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if(node==null) return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }
    //    后序遍历
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node==null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    public void levelOrder(){
        Queue<Node> queue = new ArrayQueue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()){
            Node cur = queue.dequeue();
            System.out.println(cur.e);
            if(cur.left!=null)
                queue.enqueue(cur.left);
            if(cur.right!=null)
                queue.enqueue(cur.right);
        }

    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }

    private void generateBSTString(Node node,int depth,StringBuilder res){
        if(node==null){
            res.append(generateDepthString(depth)+"null\n");
            return;
        }
        res.append(generateDepthString(depth)+node.e+"\n");
        generateBSTString(node.left,depth+1,res);
        generateBSTString(node.right,depth+1,res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i=0;i<depth;i++){
            res.append("--");
        }
        return res.toString();
    }
}
