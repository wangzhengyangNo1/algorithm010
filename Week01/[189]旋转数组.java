//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[] nums, int k) {
        rotateMy(nums, k);
    }

    /**
     * 我的题解
     * 1. 先 k %= nums.length 去除不必要的循环，k就小于nums.length；
     * 2. 使用一个数组，长度为k，将nums后 k 个元素放入新数组；
     * 3. 从后向前，依次将 length - k 前的元素向后移动 k；
     * 4. 将缓存数组中的元素放入数组前k项。
     */
    public void rotateMy(int[] nums, int k) {
        //使用另一个数组，缓存最后k个元素，前面元素向后
        k %= nums.length;
        int n = nums.length;
        int[] cacheNums = new int[k];
        for(int i = n - k, j = 0; i < n; i++, j++) {
            cacheNums[j] = nums[i];
        }
        for(int i = n - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = cacheNums[i];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
