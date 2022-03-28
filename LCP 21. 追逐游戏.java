import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class LinkNode {
    int idx;
    LinkNode next;

    public LinkNode() {
    }

    public LinkNode(int idx, LinkNode next) {
        this.idx = idx;
        this.next = next;
    }
}

class Solution {
    // 邻接链表
    private LinkNode[] linkedList;
    private boolean[] inRing;
    private Stack<Integer> stack = new Stack<>();
    private boolean[] visited;
    private int circleLength;

    // DFS找环
    private boolean dfs(int now, int pre) {
        if (visited[now]) {
            // find ans
            inRing[now] = true;
            circleLength = 1;
            while (stack.peek() != now) {
                inRing[stack.pop()] = true;
                circleLength++;
            }
            return true;
        }
        visited[now] = true;
        stack.push(now);
        LinkNode node = linkedList[now].next;
        while (node != null) {
            if (node.idx != pre) {
                if (dfs(node.idx, now)) {
                    return true;
                }
            }
            node = node.next;
        }
        stack.pop();
        return false;
    }

    // BFS找单源最短路径
    private int[] bfs(int start) {
        int[] ans = new int[linkedList.length];
        boolean[] visited = new boolean[linkedList.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int depth = -1;
        int nextLeft = 1, left = 0;
        while (nextLeft != 0) {
            depth++;
            left = nextLeft;
            nextLeft = 0;
            while (left-- > 0) {
                int next = queue.poll();
                if (ans[next] == 0) {
                    ans[next] = depth;
                }
                if (!visited[next]) {
                    visited[next] = true;
                    LinkNode node = linkedList[next].next;
                    while (node != null) {
                        queue.add(node.idx);
                        nextLeft++;
                        node = node.next;
                    }
                }
            }
        }
        return ans;
    }

    private boolean safeEnterenceExist(int[] disA, int[] disB) {
        // 遍历每一个环节点，判断disA[i]-disB[i]>1
        for (int i = 1; i < linkedList.length; i++) {
            if (inRing[i] && disA[i] - disB[i] > 1) {
                return true;
            }
        }
        return false;
    }

    public int chaseGame(int[][] edges, int startA, int startB) {
        // 构建邻接链表
        linkedList = new LinkNode[edges.length + 1];
        for (int i = 0; i < linkedList.length; i++) {
            linkedList[i] = new LinkNode(i, null);
        }
        // 初始化邻接链表
        for (int[] entry : edges) {
            linkedList[entry[0]].next = new LinkNode(entry[1], linkedList[entry[0]].next);
            linkedList[entry[1]].next = new LinkNode(entry[0], linkedList[entry[1]].next);
        }
        // 初始化其他变量
        inRing = new boolean[edges.length + 1];
        visited = new boolean[edges.length + 1];
        // DFS找环
        dfs(1, -1);
        // BFS找单源最短路径
        int[] disA = bfs(startA);
        disA[startA] = 0;
        int[] disB = bfs(startB);
        disB[startB] = 0;
        // 求B可到达的最远安全点
        int maxIdx = 0;
        for (int i = 1; i < linkedList.length; i++) {
            if (disA[i] - disB[i] > 1 && disA[i] > disA[maxIdx]) {
                maxIdx = i;
            }
        }
        // 不存在安全点，则说明A、B相邻
        if (maxIdx == 0) {
            return 1;
        }
        // 如果环节点数量为3，则A必能追上
        if (circleLength == 3) {
            return disA[maxIdx];
        }
        // 如果环节点数量>=4，则需要判断
        // 如果B在环中，则必能逃脱
        if (inRing[startB]) {
            return -1;
        }
        // 如果环中存在安全入口，则B能逃脱
        if (safeEnterenceExist(disA, disB)) {
            return -1;
        }
        // 否则B必会被追上
        return disA[maxIdx];
    }
}