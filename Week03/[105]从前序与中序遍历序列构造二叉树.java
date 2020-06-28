//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;

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


    /**
     * 思路
     *
     * 对于任意一颗树而言，前序遍历的形式总是：
     * [ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
     * 即根节点总是前序遍历中的第一个节点。而中序遍历的形式总是：
     * [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
     * 只要我们在中序遍历中定位到根节点，那么我们就可以分别知道左子树和右子树中的节点数目。由于同一颗
     * 子树的前序遍历和中序遍历的长度显然是相同的，因此我们就可以对应到前序遍历的结果中，对上述形式中
     * 的所有左右括号进行定位。
     *
     * 这样一来，我们就知道了左子树的前序遍历和中序遍历结果，以及右子树的前序遍历和中序遍历结果，我们
     * 就可以递归地对构造出左子树和右子树，再将这两颗子树接到根节点的左右位置。
     *
     * 细节：
     * 在中序遍历中对根节点进行定位时，一种简单的方法是直接扫描整个中序遍历的结果并找出根节点，但这样做
     * 的时间复杂度较高。我们可以考虑使用哈希映射（HashMap）来帮助我们快速地定位根节点。对于哈希映射中
     * 的每个键值对，键表示一个元素（节点的值），值表示其在中序遍历中的出现位置。在构造二叉树的过程之前，
     * 我们可以对中序遍历的列表进行一遍扫描，就可以构造出这个哈希映射。在此后构造二叉树的过程中，我们就
     * 只需要 O(1)O(1) 的时间对根节点进行定位了。
     *
     */
    private HashMap<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造Hash映射方便快速定位根节点
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }

        System.out.println(indexMap);
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {

        /* 终止条件 */
        if (preLeft > preRight) return null;

        /* 准备数据 */
        // 前序遍历中，第一个节点就是根节点
        int preRoot = preLeft;
        // 在中序遍历中定位根节点
        int inRoot = indexMap.get(preorder[preRoot]);
        // 创建根节点
        TreeNode root = new TreeNode(preorder[preRoot]);
        // 得到左子树的节点数目
        int leftChildCount = inRoot - inLeft;

        /* 拆分子问题 + 执行并合并结果 */
        // 递归构造左子树，并连接到根节点
        // 前序遍历中[左边界+1, 左边界 + leftChildCount]的元素就对应了中序遍历中[左边界, 根节点位置-1]的元素
        root.left = myBuildTree(preorder, inorder, preLeft + 1, preLeft + leftChildCount, inLeft, inRoot - 1);
        // 递归构造右子树，并连接到根节点
        // 前序遍历中[左边界 + leftChildCount + 1, 右边界]的元素就对应中序遍历中[根节点位置 + 1, 右边界]的元素
        root.right = myBuildTree(preorder, inorder, preLeft + leftChildCount + 1, preRight, inRoot + 1, inRight);

        /*恢复本层数据*/
        // ...
        return root;

    }

}
//leetcode submit region end(Prohibit modification and deletion)
