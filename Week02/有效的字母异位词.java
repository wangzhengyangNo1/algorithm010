//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表


import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
//        return isAnagramBySort(s, t);
//        return isAnagramByCounter(s, t);
        return isAnagramByHash(s, t);
    }

    /**
     * 使用hashMap
     * @param s
     * @param t
     * @return
     */
    private boolean isAnagramByHash(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            map.put(sChar, map.containsKey(sChar)? map.get(sChar) + 1 : 1);
            map.put(tChar, map.containsKey(tChar)? map.get(tChar) - 1 : -1);
        }

        Set<Character> keySet = map.keySet();
        Iterator<Character> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Character key = iterator.next();
            if (map.get(key) != 0) {
                return false;
            }
        }

//        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//            if (entry.getValue() != 0) return false;
//        }
        return true;
    }

    /**
     * 方法二：计数法
     * 时间复杂度O(n)
     */
    private boolean isAnagramByCounter(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for (int count : counter) {
            if (count != 0) return false;
        }
        return true;
    }

    /**
     * 方法1：排序后比较
     * 时间复杂度：O(nlogn)
     */
    private boolean isAnagramBySort(String s, String t) {
        char[] charsOfS = s.toCharArray();
        char[] charsOfT = t.toCharArray();
        Arrays.sort(charsOfS);
        Arrays.sort(charsOfT);
        return Arrays.equals(charsOfS, charsOfT);
    }


}
//leetcode submit region end(Prohibit modification and deletion)
