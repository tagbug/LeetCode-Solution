import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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

    public ListNode convertArray(Integer[] arr) {
        ListNode head = new ListNode(), node = head;
        for (Integer i : arr) {
            // System.out.println(i);
            node = node.next = new ListNode(i);
        }
        return head.next;
    }

    public Integer[] convertLinkList(ListNode node) {
        ArrayList<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        // System.out.println(list.toString());
        return list.toArray(Integer[]::new);
    }

    public void reverseK(Integer[] arr, int start, int k) {
        int len = arr.length;
        if (start + k > len) {
            return;
        }
        int left = start, right = start + k - 1;
        while (left < right) {
            Integer tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
        reverseK(arr, start + k, k);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        Integer[] arr = convertLinkList(head);
        reverseK(arr, 0, k);
        return convertArray(arr);
    }
}
// @lc code=end
