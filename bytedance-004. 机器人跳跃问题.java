import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int[] h = new int[N + 1];
            h[0] = 0;
            for (int i = 1; i <= N; i++) {
                h[i] = sc.nextInt();
            }
            System.out.println(jump(h));
        }
    }

    public static double jump(int[] H) {
        int len = H.length - 1;
        double last = H[len - 1] / 2.0;
        for (int i = len - 2; i >= 0; i--) {
            last += (H[i] - last) / 2.0;
        }
        return last;
    }
}