package com.company.wq.datastructure.tree;

import com.apple.laf.AquaIcon;

import java.util.*;

public class BinaryTree {
    public static void main(String[] args) {
        // 创建二叉树
        Node n11 = new Node(11);
        Node n10 = new Node(10);
        Node n9 = new Node(9);
        Node n8 = new Node(8);
        Node n7 = new Node(7, n11, null);
        Node n6 = new Node(6, n9, n10);
        Node n5 = new Node(5);
        Node n4 = new Node(4, null, n8);
        Node n3 = new Node(3, n6, n7);
        Node n2 = new Node(2, n4, n5);
        Node n1 = new Node(1, n2, n3);
        List<Integer> list = new ArrayList<>();
        BinaryTree binaryTree = new BinaryTree();
        //前序遍历调用
        binaryTree.preDFS(n1,list);
        System.out.println("前序遍历结果为："+list);
        list.clear();
        //中序遍历调用
        binaryTree.inDFS(n1,list);
        System.out.println("中序遍历结果为："+list);
        list.clear();
        //后序遍历调用
        binaryTree.postDFS(n1,list);
        System.out.println("后序遍历结果为："+list);
        list.clear();
        //非递归算法前序遍历
        binaryTree.unRecursivePreDFS(n1,list);
        System.out.println("非递归算法前序遍历结果为："+list);
        list.clear();
        //非递归算法中序遍历
        binaryTree.unRecursiveInDFS(n1,list);
        System.out.println("非递归算法中序遍历结果为："+list);
        list.clear();
        //非递归算法后序遍历
        binaryTree.unRecursivePostDFS(n1,list);
        System.out.println("非递归算法后序遍历结果为："+list);
        list.clear();
        //广度优先搜索
        binaryTree.BFS(n1,list);
        System.out.println("广度优先搜索遍历结果为：" + list);
    }

    /**
     * 以下三个方法preDFS、inDFS、postDFS分别为递归算法的前序、中序和后序遍历
     * @param root  根节点
     * @param list  用来存储节点的value值
     */
    //递归算法,前序遍历
    public void preDFS(Node root, List<Integer> list){
        if (root == null){
            return;
        }
        list.add(root.value);
        //左递归
        preDFS(root.left,list);
        //右递归
        preDFS(root.right,list);
    }

    //递归算法，中序遍历
    public void inDFS(Node root, List<Integer> list){
        if (root == null){
            return;
        }
        inDFS(root.left,list);
        list.add(root.value);
        inDFS(root.right,list);
    }

    //递归算法，后序遍历
    public void postDFS(Node root, List<Integer> list){
        if (root == null){
            return;
        }
        postDFS(root.left,list);
        postDFS(root.right,list);
        list.add(root.value);
    }

    /**
     * 以下为非递归算法，用到了栈的后进先出思想
     * 先弹出栈顶（同时将元素值加入到list集合中），然后将右子树入栈，再将左子树入栈
     */
    public void unRecursivePreDFS(Node root,List<Integer> list){
        if (root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            Node node = stack.pop();
            list.add(node.value);
            if (null != node.right){
                stack.push(node.right);
            }
            if (null != node.left){
                stack.push(node.left);
            }
        }
    }

    /**
     *非递归算法中序遍历，用栈实现
     * 先将左子树入栈，直到左子树没有了左子树，然后弹出栈顶，再将以栈顶为根的右子树入栈，然后是右子树的左子树入栈
     * @param root
     * @param list
     */
    public void unRecursiveInDFS(Node root,List<Integer> list){
        if (root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node tempNode = root;
        while (tempNode != null || !stack.isEmpty()){
            while(tempNode != null){
                stack.push(tempNode);
                tempNode = tempNode.left;
            }
            if (!stack.isEmpty()){
                tempNode = stack.pop();
                list.add(tempNode.value);
                tempNode = tempNode.right;
            }
        }
    }

    /**
     * 非递归算法后序遍历，用栈实现，
     * @param root
     * @param list
     */
    public void unRecursivePostDFS(Node root,List<Integer> list){
        if (root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node node = root;
        Node lastNode = root;
        while (node != null || !stack.isEmpty()){
            while (node != null){
                stack.push(node);
                node = node.left;
            }
            //获取栈顶元素
            node = stack.peek();
            //如果右子树为空或者右子树已经被访问过，则弹栈，将值存放到list集合中
            if (node.right == null || node.right == lastNode){
                list.add(node.value);
                stack.pop();
                //把已经弹栈的赋值给lastNode，用于下次比较，如果下一次lastNode与node相等，
                // 则说明在这一次已经弹栈了（即已经访问过了），需要再次弹栈当前元素
                lastNode = node;
                node = null;
            }else { //否则，继续遍历右子树
                node = node.right;
            }
        }
    }

    /**
     * 广度优先搜索，用队列实现
     */
    public void BFS(Node root,List<Integer> list){
        if (root == null){
            return;
        }
        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            list.add(node.value);
            if (null != node.left){
                queue.offer(node.left);
            }
            if (null != node.right){
                queue.offer(node.right);
            }
        }
    }
}


class Node{
    int value;
    Node left;
    Node right;
    Node(int value,Node left,Node right){
        this.value = value;
        this.left = left;
        this.right = right;
    }
    Node(int value){
        this.value = value;
    }
}