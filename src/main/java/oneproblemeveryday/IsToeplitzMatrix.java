package oneproblemeveryday;

public class IsToeplitzMatrix {
    public static void main(String[] args) {
        IsToeplitzMatrix i = new IsToeplitzMatrix();

        int[][] test1 = {
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2}
        };



        boolean b = i.isToeplitzMatrix(test1);

        System.out.println(b);


    }


    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix == null) return true;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] startPoint = {rows - 1, 0};
        boolean flag = true;
        while (startPoint[0] >= 0 && startPoint[1] < cols){
            int[] p = new int[2];
            p[0] = startPoint[0]; p[1] = startPoint[1];

            int val = matrix[p[0]][p[1]];

            while (p[0] < rows && p[1] < cols){
                if(val !=  matrix[p[0]][p[1]]) return false;
                p[0]++; p[1]++;
            }

            if(startPoint[0] == 0){
                flag = false;
            }

            if(flag){
                startPoint[0]--;
            }else {
                startPoint[1]++;
            }
        }
        return true;
    }


}
