/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能
 * 。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead","deleteHead"]
 * [[],[3],[],[],[]]
 * 输出：[null,null,3,-1,-1]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 * <p>
 * <p>
 * Related Topics 栈 设计 队列 👍 623 👎 0
 */

package com.pzliu.leetcode.editor.en;

public class YongLiangGeZhanShiXianDuiLieLcof {
    public static void main(String[] args) {
        YongLiangGeZhanShiXianDuiLieLcof solution = new YongLiangGeZhanShiXianDuiLieLcof();

        com.pzliu.leetcode.editor.en.YongLiangGeZhanShiXianDuiLieLcof.CQueue cQueue = new CQueue();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class CQueue {

        private int[] head = new int[10000];
        private int[] tail = new int[10000];

        private int headIndex;
        private int tailIndex;

        public CQueue() {
            headIndex = -1;
            tailIndex = -1;
        }

        public void appendTail(int value) {
            tail[++tailIndex] = value;
            headIndex = -1;
            for (int i = tailIndex; i >=0 ; i--) {
                head[++headIndex] = tail[i];
            }
        }

        public int deleteHead() {
            if (headIndex == -1){
                return -1;
            }
            int value = head[headIndex];
            headIndex--;

            if (headIndex != -1){
                // 输出不为空
                tailIndex = -1;
                for (int i = headIndex; i >=0 ; i--) {
                    tail[++tailIndex] = head[i];
                }
            }else {
                tailIndex = -1;
            }

            return value;
        }
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)

}