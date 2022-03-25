import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
    public Integer[] convertLinked(ListNode node) {
        ArrayList<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return list.toArray(Integer[]::new);
    }

    public ListNode convertArr(Integer[] arr) {
        ListNode head = new ListNode(), node = head;
        for (Integer i : arr) {
            node.next = new ListNode(i);
            node = node.next;
        }
        return head.next;
    }

    public Integer[] reverse(Integer[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            Integer tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
        return arr;
    }

    public ListNode reverseList(ListNode head) {
        return convertArr(reverse(convertLinked(head)));
    }
}
// @lc code=end
