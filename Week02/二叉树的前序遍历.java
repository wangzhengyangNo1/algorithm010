//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        traversal(result, root);
        return result;
    }

    /**
     * 经典解法，递归，模板。
     */
    private void traversal(List<Integer> result, TreeNode root) {
        if (root != null) {
            result.add(root.val);
            traversal(result, root.left);
            traversal(result, root.right);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
