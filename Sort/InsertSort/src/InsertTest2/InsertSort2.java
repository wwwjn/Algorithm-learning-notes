package InsertTest2;

import InsertTest1.SortTestHelper;

/**
 * @author Jiani WANG
 * @create 2020-04-01 10:05
 */
public class InsertSort2 {
    private InsertSort2(){};

    public static void sort(Comparable[] arr){
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            Comparable e= arr[i]; //复制一份
            int j=i;
            for (; j>0 && arr[j-1].compareTo(e)>0; j--) {
                arr[j]=arr[j-1];
            }
            arr[j] = e;
        }
    }
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 测试InsertionSort
    public static void main(String[] args) {

        int N = 2000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("InsertTest2.InsertSort2", arr);
        return;
    }
}
