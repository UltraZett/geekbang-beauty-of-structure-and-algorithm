/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * <p>
 * <p>
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
 * "ABCCED"
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 * <p>
 * <p>
 * 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
 * <p>
 * Related Topics 数组 回溯 矩阵 👍 694 👎 0
 */

package pzliu.leetcode.editor.cn;

public class JuZhenZhongDeLuJingLcof {
    public static void main(String[] args) {

        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();

        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(solution.exist(board, "ABCB"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        boolean isFind = false;

        public boolean exist(char[][] board, String word) {
            // 回溯算法 扩展，方便计算
            char[][] newBoard = new char[board.length + 2][board[0].length + 2];
            char[][] map = new char[board.length +2][board[0].length+2];
            for (int i = 0; i < board.length + 2; i++) {
                for (int j = 0; j < board[0].length + 2; j++) {
                    if (i == 0 || i == board.length + 1 || j == 0 || j == board[0].length+1) {
                        newBoard[i][j] = '-';
                    } else {
                        newBoard[i][j] = board[i - 1][j - 1];
                    }
                    map[i][j] = '-';
                }
            }

            //查找

            for (int i = 1; i < board.length + 2; i++) {
                for (int j = 1; j < board[0].length + 2; j++) {
                    isExist(newBoard, map,word, i, j, 0);
                    if (isFind) {
                        return true;
                    }
                }
            }

            return false;
        }

        private void isExist(char[][] newBoard,char[][] map,String word, int i, int j, int index) {

            if (word.length() == index) {
                this.isFind = true;
                return;
            }

            // 上
            if (!isFind&&map[i][j]!='*'&&newBoard[i][j] == word.charAt(index)) {
                map[i][j] = '*';
                isExist(newBoard,map,word, i, j - 1, index+1);
                map[i][j] = '-';
            }
            // 下
            if (!isFind&&map[i][j]!='*'&&newBoard[i][j] == word.charAt(index)) {
                map[i][j] = '*';
                 isExist(newBoard, map,word, i, j + 1, index+1);
                map[i][j] = '-';
            }
            // 左
            if (!isFind&&map[i][j]!='*'&&newBoard[i][j] == word.charAt(index)){
                map[i][j] = '*';
                isExist(newBoard,map,word,i - 1,j,index+1);
                map[i][j] = '-';
            }
            // 右
            if (!isFind&&map[i][j]!='*'&&newBoard[i][j] == word.charAt(index)){
                map[i][j] = '*';
                isExist(newBoard,map,word,i+1,j,index+1);
                map[i][j] = '-';
            }
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}