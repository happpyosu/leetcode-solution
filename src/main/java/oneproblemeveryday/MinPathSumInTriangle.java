package oneproblemeveryday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinPathSumInTriangle {

    public static void main(String[] args) {
        MinPathSumInTriangle m = new MinPathSumInTriangle();
        List<List<Integer>> triangle = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>(Arrays.asList(2));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(3, 4));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(6, 5, 7));
        List<Integer> list4 = new ArrayList<>(Arrays.asList(4, 1, 8, 3));

        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);


        int minimumTotal = m.minimumTotal(triangle);

        System.out.println(minimumTotal);


    }


    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int[][] dp = new int[height][height];

        dp[0][0] = triangle.get(0).get(0);

        for(int i=1; i<height; i++){
            for(int j=0; j <= i; j++){
                int preIndex1 = j;
                int preIndex2 = j - 1;
                int sum1 = preIndex1 <= i-1 ? dp[i-1][preIndex1] : Integer.MAX_VALUE;
                int sum2 = preIndex2 >= 0 ? dp[i-1][preIndex2] : Integer.MAX_VALUE;

                dp[i][j] = Math.min(sum1, sum2) + triangle.get(i).get(j);

            }
        }

        int minVal = Integer.MAX_VALUE;
        for (int i=0; i<height; i++) minVal = Math.min(dp[height-1][i], minVal);

        return minVal;
    }

}
