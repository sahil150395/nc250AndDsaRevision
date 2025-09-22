package Nc250.ArraysAndHashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {
        System.out.println(isValidSudokuUsingMaps(new char[][]{{'1', '2', '.', '.', '3', '.', '.', '.', '.'},
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

    public static boolean isValidSudokuUsingMaps(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') continue;

                String squareKey = (row / 3) + "," + (col / 3);

                if (rows.computeIfAbsent(row, k -> new HashSet<>()).contains(board[row][col]) ||
                        cols.computeIfAbsent(col, k -> new HashSet<>()).contains(board[row][col]) ||
                        squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(board[row][col])) {
                    return false;
                }

                rows.get(row).add(board[row][col]);
                cols.get(col).add(board[row][col]);
                squares.get(squareKey).add(board[row][col]);


            }
        }

        return true;
    }
}
