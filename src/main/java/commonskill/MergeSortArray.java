package commonskill;

public class MergeSortArray {

    public static int[] mergeSort(int[] arr){
        int len = arr.length;
        int[] temp = new int[arr.length];

        for(int sz=1; sz < len; sz <<= 1){

            int left, right, end;

            for(left = 0; left + sz < len; left = end){
                right = left + sz; end = right + sz;
                int p1 = left; int p2 = right;

                if(end > len) end = len;

                int next = 0;
                while (p1 < right && p2 < end) temp[next++] = (arr[p1] < arr[p2]) ? arr[p1++] : arr[p2++];

                if(p1 < right) System.arraycopy(arr, p1, temp, next, right - p1);
                else if(p2 < end) System.arraycopy(arr, p2, temp, next, end - p2);

                System.arraycopy(temp, 0, arr, left, end - left);

            }
        }
        return arr;
    }


}
