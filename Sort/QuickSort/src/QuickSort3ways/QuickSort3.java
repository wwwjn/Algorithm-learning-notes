package QuickSort3ways;

import QuickSortTest.SortTestHelper;

/**
 * @author Jiani WANG
 * @create 2020-04-19 10:58
 */
public class QuickSort3 {
    public static void main(String[] args) {
        int N = 200000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100);
        SortTestHelper.testSort("QuickSortTest.QuickSort", arr);
        boolean res = SortTestHelper.isSorted(arr);
        System.out.println("Is sorted: " + res);
    }
    public static void sort(Comparable[] arr){
        int n = arr.length;
        quicksort(arr, 0, n-1);
    }
    private static void quicksort(Comparable[] arr, int l, int r){
        //对[l...r]进行快速排序
        if(r-l<=15) {
            InsertionSort.sort(arr);
        }
        int len = r - l + 1;
        swap(arr , l, (int)(l+Math.random()*len));
        Comparable v = arr[l];
        int lt = l, gt = r+1;
        int i =lt+1;
        while(true){
            if(gt <= i) break;
            if(arr[i].compareTo(v)<0){
                lt++;
                swap(arr, lt, i);
                i++;
            }else if(arr[i].compareTo(v)>0){
                gt--;
                swap(arr,gt,i);
            }else{
                i++;
            }
        }
        swap(arr,l,lt);
        quicksort(arr,l,lt-1);  //注意此处是lt-1
        quicksort(arr, gt,r);
    }

    private static void swap(Comparable[] arr, int x, int y){
        //交换x和y
        assert x < arr.length;
        assert y < arr.length;
        Comparable tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}
