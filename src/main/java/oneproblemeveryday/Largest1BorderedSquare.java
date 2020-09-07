package oneproblemeveryday;

import java.util.Map;

public class Largest1BorderedSquare {


    public static void main(String[] args) {
        Largest1BorderedSquare l = new Largest1BorderedSquare();
        int[][] grid = {
                {1, 1, 0, 1, 0, 1},
                {1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1}
        };

        int[][] grid2 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        int[][] grid3 = {
                {1, 1, 0, 0}
        };

        int[][] grid4 = {
                {0, 1, 1, 1, 1, 0},
                {1, 1, 0, 1, 1, 0},
                {1, 1, 0, 1, 0, 1},
                {1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1}
        };




        int square4 = l.largest1BorderedSquare(grid4);
        System.out.println(square4);

    }


    public int largest1BorderedSquare(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dpToLeft = new int[rows][cols];
        int[][] dpToTop = new int[rows][cols];

        int maxSquareLen = 0;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                int left = (j - 1 >= 0) ? dpToLeft[i][j-1] : 0;
                int top = (i - 1 >= 0) ? dpToTop[i-1][j] : 0;

                int cur = grid[i][j];
                dpToLeft[i][j] = cur == 0 ? 0 : left + 1;
                dpToTop[i][j] = cur == 0 ? 0 : top + 1;

                int squareLen = Math.min(dpToLeft[i][j], dpToTop[i][j]);

                if(squareLen > 0){

                    for(int l = squareLen; l > 0; l--){
                        if(dpToLeft[i - l + 1][j] >= l && dpToTop[i][j - l + 1] >= l){
                            maxSquareLen = Math.max(maxSquareLen, l);
                            break;
                        }
                    }
                }
            }
        }
        return maxSquareLen * maxSquareLen;
    }


}
