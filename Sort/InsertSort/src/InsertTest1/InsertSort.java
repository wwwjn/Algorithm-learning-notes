package InsertTest1;

/**
 * @author Jiani WANG
 * @create 2020-03-31 18:24
 */
public class InsertSort {
    private InsertSort(){};
    public static void main(String[] args) {
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("InsertTest1.InsertSort", arr);
    }
    public static void sort(Comparable[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if(arr[j].compareTo(arr[j-1])<0){
                    swap(arr,j,j-1);
                }
            }
        }
    }
    public static void swap(Object[] arr,int i, int j){
        Object t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }


    
}
