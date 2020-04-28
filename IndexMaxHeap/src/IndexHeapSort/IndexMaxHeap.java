package IndexHeapSort;

import java.util.Arrays;

/**
 * @author Jiani WANG
 * @create 2020-04-23 10:08
 */
public class IndexMaxHeap<Item extends Comparable> {
    private int[] indexes;
    protected Item[] data;
    protected int count;  //堆的索引[1,...count]，与count相同
    protected int capacity;
    //从用户看来是index从0开始，内部的data数组编号从1开始

    // 构造函数, 构造一个空堆, 可容纳capacity个元素
    public IndexMaxHeap(int capacity){
        indexes  = new int[capacity+1];
        data = (Item[])new Comparable[capacity+1];
        this.count = 0; //存放多少个元素
        this.capacity = capacity;  //堆的总容量
    }

    // 构造函数, 通过一个给定数组创建一个最大索引堆
    // 该构造堆的过程, 时间复杂度为O(n)
    public IndexMaxHeap(Item arr[]){
        int n = arr.length;
        this.count = n;
        this.capacity = n;
        indexes  = new int[capacity+1];
        data = (Item[])new Comparable[n+1];

        for (int i = 0; i < n; i++) {
            insert(i,arr[i]);
        }
    }
    public void insert(int i,Item item){  //在数组的i位置，放入值为item的元素（不考虑i位置已有元素的情况，只能顺序插入）
        assert count+1<=capacity;
        assert i+1>=1 && i+1<=capacity;

        i++; //用户和内部的误差
        indexes[count+1]=i;  //新加入的元素在最底层
        data[i]=item;
        count++;
        shiftUp(count);  //将新加入的元素上移
    }

    private void shiftUp(int count){
        while(count/2>=1 && data[indexes[count/2]].compareTo(data[indexes[count]])<0){
            swapIndexes(count,count/2);
            count = count/2;
        }
    }
    private void swapIndexes(int i, int j){
        int t = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = t;
    }
    public Item getMax(){
        assert count > 0;
        return data[indexes[1]];
    }
    public Item extractMax(){
        assert count>0;
        Item ret = data[indexes[1]];
        swapIndexes(1, count); //删除时对data数组并不操作
        count--;
        shiftDown(1);

        return ret;
    }
    private void shiftDown(int k){
        while( 2*k <= count ){
            int j = 2*k;
            if( j+1 <= count && data[indexes[j+1]].compareTo(data[indexes[j]]) > 0 )
                j ++;

            if( data[indexes[k]].compareTo(data[indexes[j]]) >= 0 )
                break;

            swapIndexes(k, j);
            k = j;
        }
    }

    public void change(int i, Item newItem){  //i指的是用户看到的数组索引i
        i+=1;
        data[i]=newItem;

        for(int j=1;j<=count;j++){
            if(indexes[j]==i){
                shiftUp(j);
                shiftDown(j);
                return;
            }
        }
    }

    // 测试索引堆中的索引数组index
    // 注意:这个测试在向堆中插入元素以后, 不进行extract操作有效
    public boolean testIndexes(){
        int[] copyIndexes = new int[count+1];

        for( int i = 0 ; i <= count ; i ++ )
            copyIndexes[i] = indexes[i];

        copyIndexes[0] = 0;
        Arrays.sort(copyIndexes);

        // 在对索引堆中的索引进行排序后, 应该正好是1...count这count个索引
        boolean res = true;
        for( int i = 1 ; i <= count ; i ++ )
            if( copyIndexes[i-1] + 1 != copyIndexes[i] ){
                res = false;
                break;
            }
        if( !res ){
            System.out.println("Error!");
            return false;
        }
        return true;
    }

    // 测试 IndexMaxHeap
    public static void main(String[] args) {

        int N = 1000000;
        IndexMaxHeap<Integer> indexMaxHeap = new IndexMaxHeap<Integer>(N);
        for( int i = 0 ; i < N ; i ++ )
            indexMaxHeap.insert( i , (int)(Math.random()*N) );
        boolean res=indexMaxHeap.testIndexes();
        System.out.println(res);
    }
}
