package KruskalMST;

/**
 * @author Jiani WANG
 * @create 2020-04-27 10:29
 */
public class IndexMinHeap<Item extends Comparable> {
    private Item[] data;
    private int count;
    private int capacity;
    protected int[] indexes;    // 最小索引堆中的索引, indexes[x] = i 表示索引i在x的位置
    protected int[] reverse;    // 最小索引堆中的反向索引, reverse[i] = x 表示索引i在x的位置

    public IndexMinHeap(int capacity){
        data = (Item[]) new Comparable[capacity+1];
        indexes = new int[capacity+1];
        reverse = new int[capacity+1];
        for (int i = 0; i < capacity+1 ; i++) {
            reverse[i] = 0;
        }
        this.capacity = capacity;
        this.count = 0;
    }

    private void shiftDown(int k){
        while(2*k <= count){
            int j = 2*k;
            if(j+1 <= count && data[indexes[j+1]].compareTo(data[indexes[j]])<0)
                j++;
            if(data[indexes[k]].compareTo(data[indexes[j]])>0) {
                swapIndexes(k, j);
                k = j;
            }
            else
                break;
        }
    }

    public void insert(int i, Item item){
        assert count + 1 <= capacity;
        assert i+1>=1 && i+1<=count;

        // 在插入一个新元素前,还需要保证索引i所在的位置是没有元素的。
        assert !contain(i);
        i += 1;
        indexes[count+1] = i;
        reverse[i] = count+1;
        data[i] = item;
        count++;
        shiftUp(count);
    }
    boolean contain( int i ){
        assert  i + 1 >= 1 && i + 1 <= capacity;
        return reverse[i+1] != 0;
    }

    // 从最小堆中取出堆顶元素, 即堆中所存储的最小数据
    public Item extractMin(){
        assert count > 0;
        Item ret = data[indexes[1]];
        swapIndexes( 1 , count );
        reverse[indexes[count]]= 0; //删除元素
        count --;
        shiftDown(1);

        return ret;
    }
    public int extractMinIndex(){
        assert count>0;
        int ret = indexes[1] - 1;
        swapIndexes(1,count);  //把要取出的元素换到最后一个
        reverse[indexes[count]] = 0;   //删除最后一个元素
        count--;
        shiftDown(1);
        return ret;
    }
    private void swapIndexes(int i, int j){
        int t = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = t;

        reverse[indexes[i]] = i;
        reverse[indexes[j]] = j;
    }
    // 获取最小索引堆中索引为i的元素
    public Item getItem( int i ){
        assert contain(i);
        return data[i+1];
    }

    // 将最小索引堆中索引为i的元素修改为newItem
    public void change( int i , Item newItem ){

        assert contain(i);

        i += 1;
        data[i] = newItem;
        // 有了 reverse 之后,
        // 我们可以非常简单的通过reverse直接定位索引i在indexes中的位置,不用循环一遍
        shiftUp( reverse[i] );
        shiftDown( reverse[i] );
    }

    // 获取最小索引堆中的堆顶元素
    public Item getMin(){
        assert count > 0;
        return data[indexes[1]];
    }

    // 获取最小索引堆中的堆顶元素的索引
    public int getMinIndex(){
        assert count > 0;
        return indexes[1]-1;
    }

    private void shiftUp(int k){

        while( k > 1 && data[indexes[k/2]].compareTo(data[indexes[k]]) > 0 ){
            swapIndexes(k, k/2);
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

        int N = 1000000;
        IndexMinHeap<Integer> indexMinHeap = new IndexMinHeap<Integer>(N);
        for( int i = 0 ; i < N ; i ++ )
            indexMinHeap.insert( i , (int)(Math.random()*N) );
    }

}
