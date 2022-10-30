package leetcode.editor.cn;//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 示例 1: 
// 
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 933 👎 0


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
// 先序遍历 中左右
// 中序遍历 左中右
// 后序遍历 左右中
class Solution {

    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeByPreAndIn(preorder, inorder);
    }

    private TreeNode buildTreeByPreAndIn(int[] preorder, int[] inorder) {
        if (inorder.length == 0) {
            return null;
        }
        int rootVal = preorder[preIndex];
        preIndex++;
        int index = findRootValInPreOrder(rootVal, inorder);
        int[] left = new int[index];
        int[] right = new int[inorder.length - 1 - index];

        for (int i = 0; i < index; i++) {
            left[i] = inorder[i];
        }
        int rightIndex = 0;
        for (int i = index+1; i <inorder.length ; i++) {
            right[rightIndex] = inorder[i];
            rightIndex++;
        }

        TreeNode treeNode = new TreeNode(rootVal);
        treeNode.left = buildTreeByPreAndIn(preorder, left);
        treeNode.right = buildTreeByPreAndIn(preorder, right);
        return treeNode;
    }

    private int findRootValInPreOrder(int rootVal, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (rootVal == inorder[i]){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        solution.buildTree(preorder,inorder);

    }

}
//leetcode submit region end(Prohibit modification and deletion)
