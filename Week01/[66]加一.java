//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        return plusOne1(digits);
    }

    private int[] plusOne1(int[] digits) { //优化
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }

        int[] newDigits = new int[n + 1];
        System.arraycopy(digits, 0, newDigits, 1, n);
        newDigits[0] = 1;
        return newDigits;
    }

    private int[] plusOneMy(int[] digits) { //我的題解
        int k = 1;
        int n = digits.length;
        for (int i = n - 1, digit = 0; i >= 0; i--) {
            digit = digits[i] + k;
            digits[i] = digit % 10;
            k = digit  / 10;
            if (k == 0) return digits;
        }

        int[] newDigits = new int[n + 1];
        System.arraycopy(digits, 0, newDigits, 1, n);
        newDigits[0] = k;
        return newDigits;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
