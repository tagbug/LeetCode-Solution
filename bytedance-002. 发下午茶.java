import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int K = sc.nextInt();
            int N = sc.nextInt();
            int[] T = new int[N];
            for (int i = 0; i < N; i++) {
                T[i] = sc.nextInt();
            }
            System.out.println(solution(K, N, T));
        }
    }

    private static int[] T;
    private static int K;

    public static int solution(int K, int N, int[] T) {
        Main.T = T;
        Main.K = K;
        // 二分查找，最大值为步数+杯数
        int low = 0, hi = T.length + Arrays.stream(T).sum();
        while (low < hi) {
            int mid = (low + hi) / 2;
            if (check(mid)) {
                // 找更小
                hi = mid;
            } else {
                // 找更大
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * 检查在给定时间内是否能完成配送任务
     */
    public static boolean check(int time) {
        int[] record = new int[T.length];
        // 从后往前派人
        int idx = T.length - 1;
        int robotLeft = K;
        while (idx >= 0 && robotLeft > 0) {
            while (idx >= 0 && record[idx] == T[idx]) {
                idx--;
            }
            int timeLeft = time - idx - 1;
            while (idx >= 0 && timeLeft > 0) {
                record[idx]++;
                while (idx >= 0 && record[idx] == T[idx]) {
                    idx--;
                }
            }
            robotLeft--;
        }
        return idx == -1;
    }
}