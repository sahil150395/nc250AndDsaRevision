package Nc250;

//RangeSumQuery2DMatrix
public class NumMatrix {

    private int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public static void main(String[] args) {
        getPrefixSum();
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int resultSum = 0;

        for (int rowIndex = row1; rowIndex <= row2; rowIndex++) {
            for (int colIndex = col1; colIndex <= col2; colIndex++) {
                resultSum += matrix[rowIndex][colIndex];
            }
        }

        return resultSum;
    }

    public static void getPrefixSum() {
        int[][] newMatrix = new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}};
        int[][] prefixSumArray = new int[newMatrix.length][newMatrix[0].length];
        for (int rowIndex = 0; rowIndex < newMatrix.length; rowIndex++) {
            int prefixSum = 0;
            for (int colIndex = 0; colIndex < newMatrix[rowIndex].length; colIndex++) {
                prefixSum += newMatrix[rowIndex][colIndex];
                prefixSumArray[rowIndex][colIndex] = prefixSum;
            }
        }

        for (int rowIndex = 0; rowIndex < newMatrix.length; rowIndex++) {
            System.out.print("[");
            for (int colIndex = 0; colIndex < newMatrix[rowIndex].length; colIndex++) {

                System.out.print(prefixSumArray[rowIndex][colIndex] + " ");
            }
            System.out.print("]\n");
        }
    }

}
