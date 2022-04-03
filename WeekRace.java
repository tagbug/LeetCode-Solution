import java.util.Arrays;

class Solution {
    public int maximumCandies(int[] candies, long k) {
        long sum = Arrays.stream(candies).asLongStream().sum();
        // 每个人能拿到的糖果数范围：[0, sum/k]
        long low = 0, hi = sum / k;
        while (low < hi) {
            long mid = (low + hi) >> 1;
            if (check(candies, k, mid)) {
                low = mid + 1;
            } else {
                hi = mid;
            }
        }
        if (check(candies, k, low)) {
            return (int) low;
        }
        return (int) (low - 1);
    }

    public boolean check(int[] candies, long k, long perCount) {
        if (perCount == 0) {
            return true;
        }
        for (int can : candies) {
            if (can >= perCount) {
                k -= can / perCount;
            }
            if (k <= 0) {
                break;
            }
        }
        return k <= 0;
    }
}