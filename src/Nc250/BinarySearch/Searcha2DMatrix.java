package Nc250.BinarySearch;

public class Searcha2DMatrix {

    public static void main(String[] args) {
        System.out.println(searchMatrixBruteForce(new int[][]{{1, 2, 4, 8}, {10, 11, 12, 13}, {14, 20, 30, 40}}, 10));
        System.out.println(searchMatrix(new int[][]{{1, 2, 4, 8}, {10, 11, 12, 13}, {14, 20, 30, 40}}, 10));
        System.out.println(searchMatrixBruteForce(new int[][]{{1, 2, 4, 8}, {10, 11, 12, 13}, {14, 20, 30, 40}}, 10));
        System.out.println(searchMatrix(new int[][]{{1, 2, 4, 8}, {10, 11, 12, 13}, {14, 20, 30, 40}}, 15));
    }

    // Time complexity: O(rlogc) -> r is the number of rows in the matrix, c is the number of columns in the matrix
    // Space complexity: O(1)
    public static boolean searchMatrixBruteForce(int[][] matrix, int target) {

        //Iterate over the row-column pair of a matrix
        for (int row = 0; row < matrix.length; row++) {
            // implement binary search in each row
            // row number is constant, we need to find the mid using the column index
            int left = 0, right = matrix[0].length - 1;

            //this checks if the last element of the current row
            // is greater than the target else serach in the next row
            if (target > matrix[row][right]) continue;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (target > matrix[row][mid]) {
                    left = mid + 1;
                } else if (target < matrix[row][mid]) {
                    right = mid - 1;
                } else {
                    return true;
                }
            }

        }
        return false;
    }

    // Time complexity: O(log(m)+log(n))
    // Space complexity: O(1)
    public static boolean searchMatrix(int[][] matrix, int target) {
        /*
         * First we need to find the row within which the target might fall
         * This we need to do using binary search. This is O(logm) time complexity where m is number of rows.
         * Once we find the row within which the target might lie, then we perform
         * binary search on that row. This is O(logn) time complexity where n is number of columns.
         * */

        int ROWS = matrix.length, COLS = matrix[0].length;

        // To perform a binary serach on the rows, we need to check the target
        // against the last elemnt in the row and adjust our middle pointer accordingly
        int top = 0, bottom = ROWS - 1, row = 0;
        while (top <= bottom) {
            row = top + (bottom - top) / 2;

            if (target > matrix[row][COLS - 1]) {
                /*
                 * If the target is greater than the last element of the row then we need to move our
                 * top to next row than the current middle row we calculated
                 * */
                top = row + 1;
            } else if (target < matrix[row][0]) {
                /*
                 * If the target is less than the first element of the row then we need to move our
                 * bottom to a row above the current middle row we calculated
                 * */
                bottom = row - 1;
            } else {
                // means we found our desired row
                break;
            }
        }

        if (!(top <= bottom)) {
            // we didn't find the desired row, so we need to break early
            return false;
        }

        int left = 0, right = COLS - 1;
        // now we need to perform the binar search in the row where the target might exist
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < matrix[row][mid]) {
                right = mid - 1;
            } else if (target > matrix[row][mid]) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
