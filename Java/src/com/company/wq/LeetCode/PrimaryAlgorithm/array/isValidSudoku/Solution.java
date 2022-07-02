package com.company.wq.LeetCode.PrimaryAlgorithm.array.isValidSudoku;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','7','.','.','9'}
        };
        System.out.println(new Solution().isValidSudoku2(board));
    }

    //巧妙使用字符串求解
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (board[i][j] != '.'){
                    String row = "第" + i + "行" + board[i][j];
                    String col = "第" + j + "列" + board[i][j];
                    String box = "第(" + i/3 + "," + j/3 + ")个九宫格" + board[i][j];
                    if(!set.add(row) || !set.add(col) || !set.add(box)){
                        return false;
                    }
                }
            }
        }
//        System.out.println(set);
        return true;
    }

    public boolean isValidSudoku2(char[][] board){
        int len = board.length;
        //二维数组row表示的是对应的行中是否有对应的数字，比如row[0][3]
        // 表示的是第0行（实际是第1行，因为数组的下标是从0开始的）是否有数字3
        int row[][] = new int[len][len];
        int col[][] = new int[len][len];
        int box[][] = new int[len][len];

        for (int i = 0; i < len; i++){
            for (int j = 0; j < len; j++) {
                if (board[i][j] == '.'){
                    continue;
                }
                int num = board[i][j] - '0' - 1;
                int k = i / 3 * 3 + j / 3;
                if (row[i][num] != 0 || col[j][num] != 0 || box[k][num] != 0){
                    return false;
                }
                row[i][num] = col[j][num] = box[k][num] = 1;
            }
        }
        return true;
    }

    public boolean isValidSudoku3(char[][] board){
        int len = board.length;
        //二维数组row表示的是对应的行中是否有对应的数字，比如row[0][3]
        // 表示的是第0行（实际是第1行，因为数组的下标是从0开始的）是否有数字3
        int row[][] = new int[len][len];
        int col[][] = new int[len][len];
        int box[][] = new int[len][len];

        for (int i = 0; i < len; i++){
            for (int j = 0; j < len; j++) {
                if (board[i][j] == '.'){
                    continue;
                }
                int num = board[i][j] - '0' - 1;
                int k = i / 3 * 3 + j / 3;
                if (row[i][num] != 0 || col[j][num] != 0 || box[k][num] != 0){
                    return false;
                }
                row[i][num] = col[j][num] = box[k][num] = 1;
            }
        }
        return true;
    }
}
