//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        //moveZeroesTowPointer(nums);
        moveZeroesTwoPointer3(nums);
    }

    /**
     * 交换
     */
    private void moveZeroesTwoPointer3(int[] nums) {
        if (nums == null || nums.length == 0) return;
        for (int i = 0, p = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[p];
                nums[p++] = nums[i];
                nums[i] = temp;
            }
        }
    }

    private void moveZeroesTwoPointer2(int[] nums) {
        if (nums == null || nums.length == 0) return;

        //一个循环
        for (int i = 0, p = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (p != i) {
                    nums[p] = nums[i];
                    nums[i] = 0;
                }
                p++;
            }
        }


//        // 或
//        for (int i = 0, p = 0; i < nums.length; i++) {
//            if (nums[i] != 0 && nums[p] != 0) p++;
//            if (nums[i] != 0) {
//                nums[p++] = nums[i];
//                nums[i] = 0;
//            }
//        }
    }

    /**
     * 快慢指针，快指针数字非0，替换慢指针数字，替换结束后将慢指针后的元素赋0
     */
    private void moveZeroesTwoPointer(int[] nums) {
        if (nums == null) return;
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[p++] = nums[i];
            }
        }
        for (; p < nums.length; p++) {
            nums[p] = 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
