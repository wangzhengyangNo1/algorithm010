//给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();

//        traversal(list, root);

        traversalByStack(list, root);
        return list;
        
    }


    /**
     * 递归遍历，前序遍历：根-左-右
     * 先添加根节点
     * 遍历子节点
     * ... 递归
     *
     */
    private void traversal(List<Integer> list, Node root) {
        if (root != null) {
            list.add(root.val);
            if (root.children != null) {
                for (Node node : root.children) {
                    traversal(list, node);
                }
            }
        }
    }

    /**
     * 方法二：通过栈遍历
     * 1. 先将根节点从栈中取出放入list中，
     * 2. 遍历子节点倒序压入栈中，
     * 3. 取出栈顶子节点，放入list中，
     * 4. 再遍历其子节点倒序压入占中
     * ...... 循环，直到栈空为止。
     *
     */
    private void traversalByStack(List<Integer> list, Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            Node node = stack.pop();
            list.add(node.val);

            if (node.children != null) {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                }
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
