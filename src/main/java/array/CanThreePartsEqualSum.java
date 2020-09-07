package array;

import java.util.Arrays;

public class CanThreePartsEqualSum {

    public static void main(String[] args) {
        CanThreePartsEqualSum c = new CanThreePartsEqualSum();
        int[] test = {3,3,6,5,-2,2,5,1,-9,4};
        boolean b = c.canThreePartsEqualSum(test);
        System.out.println(b);
    }

    public boolean canThreePartsEqualSum(int[] A) {
        int sum = Arrays.stream(A).sum();
        int a = sum / 3;
        if(sum % 3 != 0) return false;

        int i = 0; int j = A.length - 1;

        int sumLeft = 0;
        int sumRight = 0;

        while (i < A.length){
            sumLeft += A[i];
            if(sumLeft == a) break;
            i++;
        }

        while (j >= 0){
            sumRight += A[j];
            if(sumRight == a) break;
            j--;
        }

        return i < j - 1;
    }


}
