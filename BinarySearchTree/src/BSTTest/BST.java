package BSTTest;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiani WANG
 * @create 2020-04-23 11:30
 */
public class BST<K extends Comparable,V> {
    // 测试二分搜索树
    public static void main(String[] args) {

        int N = 1000000;

        // 创建一个数组，包含[0...N)的所有元素
        Integer[] arr = new Integer[N];
        for(int i = 0 ; i < N ; i ++)
            arr[i] = new Integer(i);

        // 打乱数组顺序
        for(int i = 0 ; i < N ; i ++){
            int pos = (int) (Math.random() * (i+1));
            Integer t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = t;
        }
        // 由于我们实现的二分搜索树不是平衡二叉树，
        // 所以如果按照顺序插入一组数据，我们的二分搜索树会退化成为一个链表
        // 平衡二叉树的实现，我们在这个课程中没有涉及，
        // 有兴趣的同学可以查看资料自学诸如红黑树的实现
        // 以后有机会，我会在别的课程里向大家介绍平衡二叉树的实现的：）


        // 我们测试用的的二分搜索树的键类型为Integer，值类型为String
        // 键值的对应关系为每个整型对应代表这个整型的字符串
        BST<Integer,String> bst = new BST<Integer,String>();
        for(int i = 0 ; i < N ; i ++)
            bst.insert(new Integer(arr[i]), Integer.toString(arr[i]));

        // 对[0...2*N)的所有整型测试在二分搜索树中查找
        // 若i在[0...N)之间，则能查找到整型所对应的字符串
        // 若i在[N...2*N)之间，则结果为null
        for(int i = 0 ; i < 2*N ; i ++){
            String res = bst.search(new Integer(i));
            if( i < N )
                assert res.equals(Integer.toString(i));
            else
                assert res == null;
        }
    }


    //私有类
    private class Node{
        private K key;
        private V value;
        private Node left; //java的类名本身就是一个指针(引用数据类型)。Java没有* 和&的概念，类名、数组名本身就是指针类型。
        //eg: Data data = new Data();
        private Node right;

        private Node(K key, V value){
            this.key = key;
            this.value = value;
            left = right = null;
        }
        public Node(Node n){
            this.key = n.key;
            this.value = n.value;
            this.left = n.left;
            this.right = n.right;
        }
    }
    private Node root;
    private int count; //节点个数
    public BST(){
        this.root = null;
        this.count = 0;
    }
    public int size(){
        return count;
    }

    public void insert(K key, V value) {
        root = insert(root, key, value);
    }
    private Node insert(Node node,K key, V value){
        if(node == null){
            count++;
            return new Node(key, value);
        }
        if(key.compareTo(node.key)==0){
            node.value = value; //更新value值
        }
        else if(key.compareTo(node.key)<0){
            return insert(node.left, key, value);
        }
        else{
            return insert(node.right, key, value);
        }
        return node;
    }

    public boolean contain(K key){
        return contain(this.root, key);
    }

    private boolean contain(Node node,K key){
        if(node == null){
            return false;
        }
        if(key.compareTo(node.key)==0){
            return true;
        }
        else if(key.compareTo(node.key)<0){
            return contain(root.left,key);
        }
        else
            return contain(root.right,key);
    }
    // 在二分搜索树中搜索键key所对应的值。如果这个值不存在, 则返回null
    public V search(K key){
        return search(root , key);
    }
    private V search(Node node, K key){
        if( node == null )
            return null;
        if( key.compareTo(node.key) == 0 )
            return node.value;
        else if( key.compareTo(node.key) < 0 )
            return search( node.left , key );
        else // key > node->key
            return search( node.right, key );
    }

    // 二分搜索树的前序遍历
    public void preOrder(){
        preOrder(this.root);
    }
    private void preOrder(Node node){
        if(node != null){
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // 二分搜索树的中序遍历
    public void inOrder(){
        inOrder(this.root);
    }
    private void inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }

    // 二分搜索树的后序遍历
    public void postOrder(){
        postOrder(this.root);
    }
    private void postOrder(Node node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key);
        }
    }
    public void levelOrder(){
        LinkedList<Node> q= new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            Node node = q.remove();
            System.out.println(node.value);
            if(node.left!=null)
                q.add(node.left);
            if(node.right!=null)
                q.add(node.right);
        }
    }
    public K minimum(){
        assert count!=0;
        Node minNode = minimum(root);
        return minNode.key;
    }
    private Node minimum(Node node){
        Node minNode = node;
        while(node.left!=null){
            minNode = node.left;
        }
        return minNode;
    }
    // 寻找二分搜索树的最大的键值
    public K maximum(){
        assert count != 0;
        Node maxNode = maximum(root);
        return maxNode.key;
    }
    private Node maximum(Node node){
        Node maxNode = node;
        while(node.right !=null){
            maxNode = node.right;
        }
        return maxNode;
    }

    public void removeMin(){
        if(root!=null){
            Node minNode = removeMin(root);
        }
    }
    private Node removeMin(Node node){
        if(node.left==null){
            Node rightNode = node.right;
            node.right = null; //删除右侧节点
            count--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public void removeMax(){
        if( root != null )
            root = removeMax(root);
    }
    private Node removeMax(Node node){
        if(node.right==null){
            Node leftNode = node.left;
            node.left = null; //删除作侧节点
            count--;
            return leftNode;
        }
        node.right = removeMin(node.right);
        return node;
    }


    // 从二分搜索树中删除键值为key的节点
    public void remove(K key){
        root = remove(root, key);
    }
    private Node remove(Node node, K key){
        if(node == null){  //递归结束的情况，某节点的左子或右子为null时就结束了
            return null;
        }
        //找到待删除节点的过程
        if(key.compareTo(node.key)<0){
            node.left = remove(node.left,key);
            return node;
        }
        //找到待删除节点的过程
        else if(key.compareTo(node.key)>0){
            node.right = remove(node.right,key);
            return node;
        }
        else{  //找到了，开始删除，分三种情况
            if(node.left == null){  //只有右子
                Node rightNode = node.right;
                node.right =null;
                count--;
                return rightNode;
            }
            else if(node.right == null){  //只有右子
                Node leftNode = node.left;
                node.left =null;
                count--;
                return leftNode;
            }
            else {
                Node rightNode = new Node(minimum(node.right));
                count++;
                Node right = removeMin(node.right);  //removeMin中包含一个count--
                Node leftNode = node.left;
                rightNode.right = right;
                rightNode.left = leftNode;
                node.left = null;
                node.right = null;
                count--;
                return rightNode;
            }
        }


    }









}
