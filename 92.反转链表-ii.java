import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// @lc code=start
class Solution {
    public Integer[] convertToList(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return list.toArray(Integer[]::new);
    }

    public ListNode convertToNode(Integer[] arr) {
        ListNode head = new ListNode(), node = head;
        for (int i : arr) {
            node.next = new ListNode(i);
            node = node.next;
        }
        return head.next;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        Integer[] arr = convertToList(head);
        for (int low = left - 1, hi = right - 1; low < hi; low++, hi--) {
            int tmp = arr[low];
            arr[low] = arr[hi];
            arr[hi] = tmp;
        }
        return convertToNode(arr);
    }
}
// @lc code=end
