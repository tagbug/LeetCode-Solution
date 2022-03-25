import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

// @lc code=start
class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            if (!set.add(node)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }
}
// @lc code=end
