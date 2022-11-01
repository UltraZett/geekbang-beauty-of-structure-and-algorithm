package leetcode.editor.cn;//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
//
// 
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// Related Topics 记忆化搜索 数学 动态规划 👍 419 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[] map = new int[100];


    public int fib(int n) {
        Arrays.fill(map,-1);
        map[0] = 0;
        map[1] = 1;
        map[2] = 1;

        if (n==0){
            return map[0];
        }

        if (n == 1){
            return map[1];
        }

        if (n == 2) {
            return map[2];
        }

        if (map[n - 1] == -1) {
            int result = fib(n - 1);
            map[n - 1] = result;
        }
        int n1 = map[n - 1];

        if (map[n - 2] == -1) {
            int result = fib(n - 2);
            map[n - 2] = result;
        }
        int n2 = map[n - 2];


        return (n1 + n2)  % 1000000007;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(4));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
