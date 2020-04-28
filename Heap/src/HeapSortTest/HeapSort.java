package HeapSortTest;

import MaxHeapTest.MaxHeap;

/**
 * @author Jiani WANG
 * @create 2020-04-19 23:29
 */
public class HeapSort{
    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 1000000);
        SortTestHelper.testSort("HeapSortTest.HeapSort", arr);
        boolean res=SortTestHelper.isSorted(arr);
        System.out.println(res);
//        for( int i = 0 ; i < N ; i ++ ){
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();

//        // 确保arr数组是从大到小排列的
//        for( int i = 1 ; i < N ; i ++ )
//            assert arr[i-1] >= arr[i];

        return;
    }
    public static void sort(Comparable[] arr){
        //首先把arr变成一个最大堆，原地
        int n = arr.length;
        for (int i = (n-1-1)/2; i >= 0; i--) {
            shiftDown(arr,n,i);
        }
        for (int i = n-1; i > 0 ; i--) {
            swap(arr, 0, i);  //先把最后一个排好序
            shiftDown(arr, i,0); //保持剩余长度为i的部分仍为一个堆
        }
//        MaxHeap<Comparable> maxHeap = new MaxHeap<Comparable>(arr);
//        for( int i = n-1 ; i >= 0 ; i -- )
//            arr[i] = maxHeap.extractMax();
    }
    private static void shiftDown(Comparable[] arr, int n, int k){
        while(2*k+1 < n){
            int position = 2*k+1;
            if((position+1 < n) && arr[position+1].compareTo(arr[position])>0){
                position += 1;  //先找到左右子节点中较大的一个，作为交换的目标
            }
            if(arr[k].compareTo(arr[position])>=0){
                break;
            }
            else{
                swap(arr,k,position);
                k = position;  //追踪该元素的位置
            }
        }
    }
    // 交换堆中索引为i和j的两个元素
    private static void swap(Object[] arr, int i, int j){
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
