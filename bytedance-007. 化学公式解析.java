import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            TreeMap<String, Integer> map = new TreeMap<>();
            join(sc.nextLine(), map, 0);
            StringBuilder sb = new StringBuilder();
            for (Entry<String, Integer> entry : map.entrySet()) {
                sb.append(entry.getKey());
                sb.append(entry.getValue());
            }
            System.out.println(sb.toString());
        }
    }

    public static int join(String input, TreeMap<String, Integer> parMap, int idx) {
        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = idx; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                // 新的元素
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                while (++i < input.length()) {
                    c = input.charAt(i);
                    if (c >= 'a' && c <= 'z') {
                        sb.append(c);
                    } else {
                        break;
                    }
                }
                // 数字（可选）
                int num = 1;
                if (c >= '0' && c <= '9') {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(c);
                    while (++i < input.length()) {
                        c = input.charAt(i);
                        if (c >= '0' && c <= '9') {
                            sb2.append(c);
                        } else {
                            break;
                        }
                    }
                    num = Integer.parseInt(sb2.toString());
                }
                // 加入树集
                map.put(sb.toString(), num);
            } else {
                // 括号，嵌套序列
                if (c == '(' || c == '[') {
                    join(input, map, i + 1);
                } else {
                    // 读取数字（可选）
                    int num = 1;
                    if (++i < input.length()) {
                        c = input.charAt(i);
                    }
                    if (c >= '0' && c <= '9') {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(c);
                        while (++i < input.length()) {
                            c = input.charAt(i);
                            if (c >= '0' && c <= '9') {
                                sb2.append(c);
                            } else {
                                break;
                            }
                        }
                        num = Integer.parseInt(sb2.toString());
                    }
                    // 合并序列
                    for (Entry<String, Integer> entry : map.entrySet()) {
                        Integer count = parMap.get(entry.getKey());
                        if (count == null) {
                            parMap.put(entry.getKey(), entry.getValue() * num);
                        } else {
                            parMap.put(entry.getKey(), entry.getValue() * num + count);
                        }
                    }
                    // 返回索引，跳过闭合括号
                    return i + 1;
                }
            }
        }
        return input.length();
    }
}