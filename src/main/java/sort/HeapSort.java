package sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] A = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};

        HeapSort h = new HeapSort();
        h.heapSort(A);


        System.out.println(Arrays.toString(A));

    }


    public void heapSort(int[] arr){

        buildMaxHeap(arr);
        int size = arr.length;
        for(int i=arr.length - 1; i>=1; i--){
            swap(arr, 0, i);
            maxHeapify(arr, 0, --size);
        }
    }


    public void buildMaxHeap(int[] arr){
        int size = arr.length;
        for(int i=(size - 2) / 2; i>=0; i--){
            maxHeapify(arr, i, size);
        }
    }

    private void maxHeapify(int[] arr, int i, int size){
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int largest = i;
        if(left < size && arr[left] > arr[i]){
            largest = left;
        }

        if(right < size && arr[right] > arr[largest]){
            largest = right;
        }

        if(largest != i){
            swap(arr, i, largest);
            maxHeapify(arr, largest, size);
        }

    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
