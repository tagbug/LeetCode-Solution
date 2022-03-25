import java.util.*;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// @lc code=start
class LRUCache {
    static class LinkNode {
        int key, val;
        LinkNode pre, next;

        LinkNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    LinkNode head, tail;
    int size, cap;
    HashMap<Integer, LinkNode> map;

    public void print(LinkNode node) {
        System.out.print(node.val);
        node = node.next;
        while (node != null) {
            System.out.print("->" + node.val);
            node = node.next;
        }
        System.out.println();
    }

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity + 1);
        cap = capacity;
    }

    public void adjust(LinkNode node) {
        if (node == tail) {
            return;
        }
        if (node == head) {
            node.pre = tail;
            tail = tail.next = node;
            head = head.next;
            head.pre = null;
            node.next = null;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.pre = tail;
            tail = tail.next = node;
            node.next = null;
        }
    }

    public int get(int key) {
        LinkNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        // print(node);
        adjust(node);
        // System.out.print("head: ");
        // print(head);
        return node.val;
    }

    public void put(int key, int value) {
        LinkNode node = map.get(key);
        if (node == null) {
            node = new LinkNode(key, value);
            map.put(key, node);
            if (tail == null) {
                head = tail = node;
            } else {
                node.pre = tail;
                tail = tail.next = node;
            }
            if (size == cap) {
                // 达到既定容量
                map.remove(head.key);
                head = head.next;
                head.pre = null;
            } else {
                size++;
            }
        } else {
            node.val = value;
            adjust(node);
        }
        // System.out.print("PUT head: ");
        // print(head);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end
