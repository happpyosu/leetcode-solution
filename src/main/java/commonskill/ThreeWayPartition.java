package commonskill;

public class ThreeWayPartition {

    public static int threeWayPartition(int[] arr, int mid){
        int i = 0, j = 0;
        int n = arr.length - 1;

        while (j <= n){
            if(arr[j] < mid){
                swap(arr, i++, j++);
            }else if(arr[j] > mid){
                swap(arr, j, n--);
            }else {
                j++;
            }

        }

        return i;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
