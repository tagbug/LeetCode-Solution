/*
 * @lc app=leetcode.cn id=670 lang=java
 *
 * [670] 最大交换
 */

// @lc code=start
class Solution {
    public int maximumSwap(int num) {
        // 拆分为数组
        int[] arr = new int[(int) (Math.log10(num) + 1)];

        int div = (int) Math.pow(10, (int) Math.log10(num));
        for (int i = 0; i < arr.length; i++, div /= 10) {
            arr[i] = num / div % 10;
        }

        // 最大交换
        for (int i = 0; i < arr.length; i++) {
            int max = -1, maxIdx = 0;
            for (int j = arr.length - 1; j >= i; j--) {
                if (max < arr[j]) {
                    max = arr[j];
                    maxIdx = j;
                }
            }
            if (max != arr[i]) {
                arr[maxIdx] ^= arr[i];
                arr[i] ^= arr[maxIdx];
                arr[maxIdx] ^= arr[i];
                break;
            }
        }

        // 得到解
        int res = 0;
        int multi = (int) Math.pow(10, (int) Math.log10(num));
        for (int i : arr) {
            res += multi * i;
            multi /= 10;
        }

        return res;
    }
}
// @lc code=end
