//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // return groupAnagramsMy(strs);

        // return groupAmagramsMap(strs);

        return groupAnagramsMap1(strs);
    }

    private List<List<String>> groupAnagramsMap1(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        int[] counter = new int[26];
        for (String str: strs) {
            Arrays.fill(counter, 0);

            for (int i = 0; i < str.length(); i++) {
                char iChar = str.charAt(i);
                counter[iChar - 'a']++;
            }

            StringBuilder builder = new StringBuilder();
            for (int count: counter) {
                builder.append(count).append("#");
            }
            String key = builder.toString();
            if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }


    /**
     * 题解一：
     * 维护一个映射 ans : {String -> List}，其中每个键 \text{K}K 是一个排序字符串，每个值是初始输入的字符串列表，排序后等于 \text{K}K。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/group-anagrams/solution/zi-mu-yi-wei-ci-fen-zu-by-leetcode/
     * 来源：力扣（LeetCode）
     *
     */
    private List<List<String>> groupAmagramsMap(String[] strs) {
        List<List<String>> groups = new ArrayList<>();
        if (strs == null || strs.length == 0) return groups;
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = String.valueOf(chars);
            if (!map.containsKey(sortedStr)) map.put(sortedStr, new ArrayList<String>());
            map.get(sortedStr).add(str);
        }
        groups.addAll(map.values());
        return groups;

    }


    /**
     * 我的解法
     * 遍历数组，遍历分组，
     * 比较字符串和每组第一项是否是是异位，即找异位组
     * 找到的话，添加到该组，
     * 没有找到，即新建一个分组将该字符串放到分组中。
     */
    private List<List<String>> groupAnagramsMy(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        for(String str: strs) {
            boolean handled = false;
            for (List<String> list : result) {
                if (isAnagrams(str, list.get(0))) {
                    list.add(str);
                    handled = true;
                }
            }

            if (!handled) {
                List<String> list = new ArrayList<>();
                list.add(str);
                result.add(list);
            }
        }

        return result;
    }

    public boolean isAnagrams(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] counter = new int[26];

        for(int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a'] += 1;
            counter[t.charAt(i) - 'a'] -= 1;
        }

        for(int count: counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
