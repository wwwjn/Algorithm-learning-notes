package MergeTest1;

/**
 * @author Jiani WANG
 * @create 2020-04-18 20:47
 */
public class MergeSortTest {
    //private MergeSortTest(){};
    public static void main(String[] args) {
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("MergeTest1.MergeSortTest", arr);
        return;
    }
    public static void sort(Comparable[] arr){
        sort(arr,0, (arr.length-1));
    }
    public static void sort(Comparable[] arr, int l, int r){
        //对[l,...,r]进行排序
        if(l>=r){
            return;
        }
        int mid = (l+r)/2;
        sort(arr, l, mid);
        sort(arr, mid+1,r);
        merge(arr, l, mid, r);
    }
    public static void merge(Comparable[] arr, int l, int mid, int r){
        int i=l, j = mid+1;
        Comparable[] aux= new Comparable[r - l + 1];
        for (int k = l; k <= r ; k++) {
            aux[k-l]=arr[k];  //注意aux数组索引都要减去l
        }
        for (int m = l; m <= mid ; m++) {
            if(i > mid){
                arr[m]=aux[j-l];
                j++;
            }
            else if(j>r){
                arr[m] = aux[i-l];
                i++;
            }
            else if(aux[i-l].compareTo(aux[j-l])<= 0){
                arr[m]=aux[i-l];
                i++;

            }
            else{
                arr[m]=aux[j-l];
                j++;
            }
        }
    }
}
