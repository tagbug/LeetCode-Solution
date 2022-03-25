/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode preLow = null, low = head, hi = head.next;
        boolean repeated = false;
        int now = low.val;
        while (hi != null) {
            if (hi.val == now) {
                repeated = true;
                hi = hi.next;
            } else {
                // System.out.println(
                        // (preLow == null ? "null" : preLow.val) + " " + low.val + " " + hi.val + " " + repeated);
                if (repeated) {
                    if (preLow == null) {
                        head = hi;
                    } else {
                        preLow.next = hi;
                    }
                    repeated = false;
                } else {
                    preLow = low;
                }
                low = hi;
                now = hi.val;
                hi = hi.next;
            }
        }
        if (repeated) {
            if (preLow == null) {
                head = null;
            } else {
                preLow.next = null;
            }
        }
        return head;
    }
}
// @lc code=end
