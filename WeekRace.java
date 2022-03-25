import java.util.*;

public class WeekRace {
    public int countHillValley(int[] nums) {
        int len = nums.length;
        int count = 0;
        for (int i = 1; i < len - 1; i++) {
            int num = nums[i];
            if (num == nums[i - 1]) {
                continue;
            }
            // 左右不相等
            int left = num, right = num;
            for (int l = i - 1; l >= 0; l--) {
                if (nums[l] != num) {
                    left = nums[l];
                    break;
                }
            }
            for (int r = i + 1; r < len; r++) {
                if (nums[r] != num) {
                    right = nums[r];
                    break;
                }
            }
            if ((num > left && num > right) || (num < left) && (num < right)) {
                count++;
            }
        }
        return count;
    }
}
