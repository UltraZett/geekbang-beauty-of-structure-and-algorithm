/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * <p>
 * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3,4
 * ,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。
 * <p>
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..
 * ., a[n-2]] 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：numbers = [3,4,5,1,2]
 * 输出：1
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：numbers = [2,2,2,0,1]
 * 输出：0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == numbers.length
 * 1 <= n <= 5000
 * -5000 <= numbers[i] <= 5000
 * numbers 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 * <p>
 * <p>
 * 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-
 * sorted-array-ii/
 * <p>
 * Related Topics 数组 二分查找 👍 717 👎 0
 */

package pzliu.leetcode.editor.cn;

public class XuanZhuanShuZuDeZuiXiaoShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new XuanZhuanShuZuDeZuiXiaoShuZiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minArray(int[] numbers) {
            //实际为二分查找
            return findMin(numbers, 0, numbers.length - 1);
        }

        private int findMin(int[] numbers, int start, int end) {

            if (start >= end){
                return numbers[(start+end)/2];
            }

            int mid = (start + end) /2;
            // 左边
            int minLeft = findMin(numbers,start,mid);
            // 右边
            int minRight = findMin(numbers,mid + 1,end);
            return Math.min(minRight,minLeft);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}