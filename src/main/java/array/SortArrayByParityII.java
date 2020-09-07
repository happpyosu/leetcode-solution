package array;

import java.util.Arrays;

import static commonskill.CommonSkills.swap;

// 按奇偶排序数组
public class SortArrayByParityII {

    public static void main(String[] args) {
        SortArrayByParityII s = new SortArrayByParityII();
        int[] a = {4, 2, 5, 7};
        s.sortArrayByParityII(a);
        System.out.println(Arrays.toString(a));
    }

    public int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for(int i=0; i<A.length; i += 2){
            if(A[i] % 2 != 0){
                while (A[j] % 2 == 1){
                    j += 2;
                }
                swap(A, i, j);
            }
        }
        return A;
    }

}
