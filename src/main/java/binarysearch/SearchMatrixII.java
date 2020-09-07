package binarysearch;

public class SearchMatrixII {

    public static void main(String[] args) {
        int[][] test = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
    };

        SearchMatrixII s = new SearchMatrixII();
        boolean b = s.searchMatrix(test, 99);
        System.out.println(b);


    }


    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int i = 0;
        int j = cols - 1;

        while (i < rows && j >= 0){
            if(matrix[i][j] > target) j--;
            else if(matrix[i][j] < target) i++;
            else return true;
        }
        return false;
    }

}
