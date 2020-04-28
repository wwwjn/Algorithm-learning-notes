package MaxHeapTest2;

/**
 * @author Jiani WANG
 * @create 2020-04-19 23:16
 */

public class MaxHeapNew<Item extends Comparable> { //T要继承Comparable

    protected Item[] data;
    protected int count;  //堆的索引[1,...count]，与count相同
    protected int capacity;

    // 构造函数, 构造一个空堆, 可容纳capacity个元素
    public MaxHeapNew(int capacity){
        data = (Item[])new Comparable[capacity+1];
        this.count = 0; //存放多少个元素
        this.capacity=capacity;  //堆的总容量
    }

    // 构造函数, 通过一个给定数组创建一个最大堆
    // 该构造堆的过程, 时间复杂度为O(n)
    public MaxHeapNew(Item arr[]){
        int n = arr.length;
        this.count = n;
        this.capacity = n;
        data = (Item[])new Comparable[n+1];

        for (int i = 0; i < n; i++) {
            insert(arr[i]);
        }
    }

    // 返回堆中的元素个数
    public int size(){
        return count;
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty(){
        return count == 0;
    }

    // 像最大堆中插入一个新的元素 item
    public void insert(Item item){
        assert count + 1 <= capacity;
        data[count+1] = item;
        count++;
        shiftUp(count);
    }

    // 从最大堆中取出堆顶元素, 即堆中所存储的最大数据
    public Item extractMax(){
        assert this.count > 0;
        Item ret = data[1];
        swap(1,count);
        shiftDown(1);
        count--;
        return ret;
    }

    // 获取最大堆中的堆顶元素
    public Item getMax(){
        assert( count > 0 );
        return data[1];
    }


    // 交换堆中索引为i和j的两个元素
    private void swap(int i, int j){
        Item tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    //********************
    //* 最大堆核心辅助函数
    //********************
    private void shiftUp(int k) {
        while(true) {
            int parent = k / 2; //默认向下取整
            if(parent < 1) break;
            if(data[parent].compareTo(data[k]) < 0) {
                swap(parent, k);
                k = parent;
            }else{
                break;
            }
        }
//        while( k > 1 && data[k/2].compareTo(data[k]) < 0 ){
//            swap(k, k/2);
//            k /= 2;
//        }
    }
    private void shiftDown(int k){
        int temp = k;  //temp指向待交换的结点
        while(2*temp<=count){
            if(2*temp+1<=count){  //有右子节点
                //无需比较的情况
                if(data[k].compareTo(data[2*temp])>0 && data[k].compareTo(data[2*temp+1])>0){
                    break; //之后也不需要swap
                }
                if(data[2*temp+1].compareTo(data[2*temp])>0){ //右子节点大
                    temp = 2*temp +1 ;
                }
                else{
                    temp = temp*2;
                }
            }else{
                //无需比较的情况
                if(data[k].compareTo(data[2*temp])>0){
                    break;
                }
                temp = temp*2;
            }
        }
        swap(temp,k);
    }

    // 测试 MaxHeap
    public static void main(String[] args) {
        MaxHeapTest.MaxHeap<Integer> maxHeap = new MaxHeapTest.MaxHeap<Integer>(100);
        int N = 100; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for( int i = 0 ; i < N ; i ++ )
            maxHeap.insert( new Integer((int)(Math.random() * M)) );

        Integer[] arr = new Integer[N];
        // 将maxheap中的数据逐渐使用extractMax取出来
        // 取出来的顺序应该是按照从大到小的顺序取出来的
        for( int i = 0 ; i < N ; i ++ ){
            arr[i] = maxHeap.extractMax();
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 确保arr数组是从大到小排列的
        for( int i = 1 ; i < N ; i ++ )
            assert arr[i-1] >= arr[i];
    }
}

