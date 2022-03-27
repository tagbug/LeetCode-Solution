import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
        int overFlow = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = num1.length() - 1, k = 0; i >= 0; i--, k++) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int bitI = num1.charAt(i) - '0';
                int bitJ = num2.charAt(j) - '0';
                int res = bitI * bitJ + overFlow;
                overFlow = res / 10;
                res = res % 10;
                if (list.size() < k + num2.length() - j) {
                    list.add(res);
                } else {
                    int ori = list.get(k + num2.length() - j - 1);
                    ori += res;
                    overFlow += ori / 10;
                    ori = ori % 10;
                    list.set(k + num2.length() - j - 1, ori);
                }
            }
            if (overFlow != 0) {
                list.add(overFlow);
                overFlow = 0;
            }
        }
        if (overFlow != 0) {
            list.add(overFlow);
        }
        StringBuilder sb = new StringBuilder();
        if (list.get(list.size() - 1) == 0) {
            return "0";
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
// @lc code=end
