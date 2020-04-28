package KruskalMST;

/**
 * @author Jiani WANG
 * @create 2020-04-27 9:33
 */
public class MinHeap<Item extends Comparable> {
    private Item[] data;
    private int count;
    private int capacity;

    public MinHeap(int capacity){
        data = (Item[]) new Comparable[capacity+1];
        this.capacity = capacity;
        this.count = 0;
    }
    public MinHeap(Item[] arr){
        int n = arr.length;
        data = (Item[]) new Comparable[n+1];
        capacity = n;
        for (int i = 0; i < n; i++) {
            data[i+1] = arr[i];
        }
        count = n;
        for (int i = n/2; i>=1; i--) {
            shiftDown(i);
        }
    }
    private void shiftDown(int k){
        while(2*k <= count){
            int j = 2*k;
            if(j+1 <= count && data[j+1].compareTo(data[j])<0)
                j++;
            if(data[k].compareTo(data[j])>0) {
                swap(k, j);
                k = j;
            }
            else
                break;
        }
    }
    private void swap(int i, int j){
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
    public void insert(Item item){

        assert count + 1 <= capacity;
        data[count+1] = item;
        count ++;
        shiftUp(count);
    }

    // 从最小堆中取出堆顶元素, 即堆中所存储的最小数据
    public Item extractMin(){
        assert count > 0;
        Item ret = data[1];

        swap( 1 , count );
        count --;
        shiftDown(1);

        return ret;
    }

    // 获取最小堆中的堆顶元素
    public Item getMin(){
        assert( count > 0 );
        return data[1];
    }
    private void shiftUp(int k){

        while( k > 1 && data[k/2].compareTo(data[k]) > 0 ){
            swap(k, k/2);
            k /= 2;
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
    // 测试 MinHeap
    public static void main(String[] args) {

        MinHeap<Integer> minHeap = new MinHeap<Integer>(100);
        int N = 100; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for( int i = 0 ; i < N ; i ++ )
            minHeap.insert( new Integer((int)(Math.random() * M)) );

        Integer[] arr = new Integer[N];
        // 将minheap中的数据逐渐使用extractMin取出来
        // 取出来的顺序应该是按照从小到大的顺序取出来的
        for( int i = 0 ; i < N ; i ++ ){
            arr[i] = minHeap.extractMin();
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 确保arr数组是从小到大排列的
        for( int i = 1 ; i < N ; i ++ )
            assert arr[i-1] <= arr[i];
    }
}
