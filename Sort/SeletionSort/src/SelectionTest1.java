/**
 * @author Jiani WANG
 * @create 2020-03-31 16:51
 */
public class SelectionTest1 {
    public static void main(String[] args) {
        int[] arr={10,9,8,7,6,5,4,3,2,1};
        SelectionTest1 select=new SelectionTest1();
        select.sort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
    //之后可以修改成泛型
    public static void sort(int[] arr){
        int n = arr.length;
        for(int i=0; i < n; i++){
            int minIndex = i;
            for(int j=i;j<n;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            swap(arr,i,minIndex);
        }

    }
    public static void swap(int[] arr, int i, int index){
        int t=arr[i];
        arr[i]=arr[index];
        arr[index]=t;
    }
}
