package others;

import java.util.Arrays;

//todo
public class RotateMatrix90Degree {

    public static void main(String[] args) {
        RotateMatrix90Degree r = new RotateMatrix90Degree();
        int[][] matrix = {
            {5, 1, 9, 11},
            {2, 4, 8,10},
            {13, 3, 6, 7},
                {15,14,12,16}
        };

        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        r.rotate(matrix2);
        for (int[] ints : matrix2) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int circles = (n % 2 == 0) ? (n - 1) / 2 : n /2;

        for(int c=0; c <= circles; c++){
            rotateCircle(c, n, matrix);
            n -= 2;
        }
    }

    // 1、(x, y) -> (circle + size - 1, x)
    // 2、(x, y) -> (circle + size - 1 - (y - circle), circle + size - 1)
    // 3、(x, y) -> (circle, x)
    private void rotateCircle(int circle, int size, int[][] matrix){
        for(int i=0; i < size - 1; i++){
            int x = circle + i; int y = circle;
            int u = circle + size - 1; int v = x;
            swap(matrix, x, y, u, v);
        }

        for(int i=0; i < size - 1; i++){
            int x = circle + size - 1; int y = circle + i;
            int u = 2*circle + size - 1 - y; int v = circle + size - 1;
            swap(matrix, x, y, u, v);
        }

        for(int i=0; i < size - 1; i++){
            int x = circle + size - 1 - i; int y = circle + size - 1;
            int u = circle; int v = x;
            swap(matrix, x, y, u, v);
        }
    }

    private void swap(int[][] matrix, int x1, int y1, int x2, int y2){
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }

}
