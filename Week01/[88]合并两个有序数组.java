//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //mergeMySolution(nums1, m, nums2, n);
        merge2(nums1, m, nums2, n);
    }

    /**
     *  假设nums1的length为 m + n；
     *  双指针遍历，较大者从后往前放入nums1
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);

    }

    /**
     * 先数组2 copy 到数组1 后面，再排序
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);

    }

    /**
     * 我的题解，优化
     * 用新数组copy数组nums1的前 m 元素，减少最后copy数量。
     */
    public void mergeMy(int[] nums1, int m, int[] nums2, int n) {
        int[] newNums = new int[m];
        for (int i = 0; i < m; i++) {
            newNums[i] = nums1[i];
        }
        int i = 0, j = 0, k = 0;
        for(; i < m && j < n;) {
            nums1[k++] = (newNums[i] < nums2[j]) ? newNums[i++] : nums2[j++];
        }
        if (i < m) {
            for (; i < m; i++) {
                nums1[k++] = newNums[i];
            }
        } else if (j < n) {
            for (; j < n; j++) {
                nums1[k++] = nums2[j];
            }
        }

    }

    /**
     * 我的题解
     * 1. 新建一个数组，长度是 m + n;
     * 2. 双指针（i 和 j）遍历数组1和数组2，比较两数组i和j位置的元素大小，
     * 较小者放进新数组中，下标加1，直到其中一个数组所有数字添加到新数组中；
     * 3. 把没有遍历完的数组的剩余元素添加到新数组中；
     * 4. 把新数组copy到数组1中。
     */
    private void mergeMySolution(int[] nums1, int m, int[] nums2, int n) {
        int[] newNums = new int[m + n];
        int i = 0, j = 0, k = 0;
        for(; i < m && j < n;) {
            newNums[k++] = (nums1[i] < nums2[j]) ? nums1[i++] : nums2[j++];
        }
        if (i < m) {
            for (; i < m; i++) {
                newNums[k++] = nums1[i];
            }
        } else if (j < n) {
            for (; j < n; j++) {
                newNums[k++] = nums2[j];
            }
        }
        for (int l = 0; l < m + n; l++) {
            nums1[l] = newNums[l];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
