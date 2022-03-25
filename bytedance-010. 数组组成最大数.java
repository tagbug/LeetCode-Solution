import java.util.*;

class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String input = sc.nextLine();
            StringBuilder sb = new StringBuilder(input);
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(0);
            String[] nums = sb.toString().split(",");
            System.out.println(getMax(nums));
        }
    }

    public static String getMax(String[] nums) {
        Arrays.sort(nums, (b, a) -> (a + b).compareTo(b + a));
        StringBuilder sb = new StringBuilder();
        for (String s : nums) {
            sb.append(s);
        }
        return sb.toString();
    }
}