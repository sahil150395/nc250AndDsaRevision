package Nc250;

import java.util.HashSet;

public class ValidSudoku {

    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]{{'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}));
    }

    public static boolean isValidSudoku(char[][] board) {

        //checks for distincts in a row
        for (int rowNum = 0; rowNum < board.length; rowNum++) {
            HashSet<Character> sudokuRowNums = new HashSet<>();
            for (int colNum = 0; colNum < board[0].length; colNum++) {
                if (board[rowNum][colNum] == '.') continue;
                if (sudokuRowNums.contains(board[rowNum][colNum])) return false;
                sudokuRowNums.add(board[rowNum][colNum]);

            }
        }

        //checks for distincts in a column
        for (int colNum = 0; colNum < board[0].length; colNum++) {
            HashSet<Character> sudokuColumnNums = new HashSet<>();
            for (int rowNum = 0; rowNum < board.length; rowNum++) {
                if (board[rowNum][colNum] == '.') continue;
                if (sudokuColumnNums.contains(board[rowNum][colNum])) return false;
                sudokuColumnNums.add(board[rowNum][colNum]);

            }
        }

        // check for uniqueness within the 3*3 squares
        for (int square = 0; square < 9; square++) {
            HashSet<Character> seen = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    if (board[row][col] == '.') continue;
                    if (seen.contains(board[row][col])) return false;
                    seen.add(board[row][col]);
                }
            }
        }

        return true;
    }
}
