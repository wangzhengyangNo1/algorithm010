//给定一个二叉树，返回它的中序 遍历。 
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
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.List;
import java.util.Stack;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        //traversal(list, root);
        traversalByStack(list, root);
        return list;
    }


    private void traversalByStack(List<Integer> list, TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.empty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
    }

    /**
     * 方法一：经典遍历，基于递归，遍历模板。
     */
    private void traversal(List<Integer> list, TreeNode root) {
        if (root != null) {
            traversal(list, root.left);
            list.add(root.val);
            traversal(list, root.right);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
