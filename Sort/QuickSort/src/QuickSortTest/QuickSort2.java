package QuickSortTest;

/**
 * @author Jiani WANG
 * @create 2020-04-19 10:12
 */
public class QuickSort2 {
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
        quicksort(arr,l,p-1);  //注意此处是p-1
        quicksort(arr, p+1,r);
    }
    private static int partition(Comparable[] arr, int l, int r){
        int len = r - l + 1;
        swap(arr , l, (int)(l+Math.random()*len));
        Comparable v = arr[l];
        int i = l;
        for (int j = l+1; j <= r; j++) {
            if(arr[j].compareTo(v) < 0 ) {
                i++;
                swap(arr,i,j);
            }else{
                continue;
            }
        }
        swap(arr,l,i);
        return i;
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
