package greedy;

import java.util.Arrays;

// leetcode 1005
public class LargestSumAfterKNegations {

    public static void main(String[] args) {
        LargestSumAfterKNegations l = new LargestSumAfterKNegations();
        int[] A = {2, -3, -1, 5, -4};
        int[] A1 = {3, -1, 0, 2};
        int negations = l.largestSumAfterKNegations(A1, 3);
        System.out.println(negations);
    }


    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int minIndex = 0;

        while (K > 0){
            A[minIndex] = -A[minIndex];
            K--;
            if(minIndex + 1 < A.length && A[minIndex] > A[minIndex + 1])
                minIndex++;
        }

        return Arrays.stream(A).sum();
    }

}
