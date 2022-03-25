import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n + 1];
            int[] b = new int[m + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
            }
            for (int j = 1; j <= m; j++) {
                b[j] = sc.nextInt();
            }
        }
    }

    public static int minMove(int n, int m, int[] a, int[] b) {
        
        return 0;
    }
}