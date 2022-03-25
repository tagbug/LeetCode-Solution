import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>(strs.length);
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            ArrayList<String> list = map.get(key);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(s);
            map.put(key, list);
        }
        return List.copyOf(map.values());
    }
}
// @lc code=end
