package QuickSortTest;

import static java.lang.Math.random;

/**
 * @author Jiani WANG
 * @create 2020-04-19 9:11
 */
public class QuickSort {
    public static void main(String[] args) {
        int N = 200000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100);
        SortTestHelper.testSort("QuickSortTest.QuickSort", arr);
        boolean res = SortTestHelper.isSorted(arr);
        System.out.println("Is sorted: " + res);
        //对于有大量重复元素时的测试
        Integer[] arr2 = SortTestHelper.generateRandomArray(N, 0, 100);
        SortTestHelper.testSort("QuickSortTest.QuickSort2", arr2);
        boolean res2 = SortTestHelper.isSorted(arr2);
        System.out.println("Is sorted: " + res2);
    }
    public static void sort(Comparable[] arr){
        int n = arr.length;
        quicksort(arr, 0, n-1);
    }
    private static void quicksort(Comparable[] arr, int l, int r){
        //对[l...r]进行快速排序
        if(l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        quicksort(arr,l,p-1);
        quicksort(arr, p+1,r);
    }
    private static int partition(Comparable[] arr, int l, int r){
        int len = r - l + 1;
        swap(arr , l, (int)(l+Math.random()*len));
        Comparable v = arr[l];
        int i = l+1, j = r;
        while(true){
            while(i <= r && arr[i].compareTo(v)<0){
                i++;
            }
            while(j >= l+1 && arr[j].compareTo(v)>0){
                j--;
            }
            if(i >= j)  //这里写不写=都可以，
                break;
            swap(arr, i , j);
            i++;
            j--;
        }
        swap(arr,l,j);
        return j;

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
