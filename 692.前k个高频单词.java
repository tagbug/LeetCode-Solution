import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;

/*
 * @lc app=leetcode.cn id=692 lang=java
 *
 * [692] 前K个高频单词
 */

// @lc code=start
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>(words.length);
        for (String word : words) {
            Integer count = map.getOrDefault(word, 0);
            map.put(word, count + 1);
        }
        PriorityBlockingQueue<Entry> pq = new PriorityBlockingQueue<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(new Entry(entry.getKey(), entry.getValue()));
        }
        ArrayList<String> ans = new ArrayList<>();
        while (k-- > 0) {
            ans.add(pq.poll().s);
        }
        return ans;
    }
}

class Entry implements Comparable<Entry> {
    String s;
    int count;

    public Entry(String s, int count) {
        this.s = s;
        this.count = count;
    }

    @Override
    public int compareTo(Entry o) {
        int minus = o.count - count;
        if (minus == 0) {
            return s.compareTo(o.s);
        }
        return minus;
    }
}
// @lc code=end
