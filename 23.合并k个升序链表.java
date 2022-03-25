import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
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
    public ArrayList<Integer> convert(ListNode node) {
        ArrayList<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return list;
    }

    public ListNode convertRes(ArrayList<Integer> list) {
        ListNode head = new ListNode(), node = head;
        for (Integer i : list) {
            node.next = new ListNode(i);
            node = node.next;
        }
        return head.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer>[] arrList = new ArrayList[lists.length];
        int count = 0;
        for (int i = 0; i < lists.length; i++) {
            arrList[i] = convert(lists[i]);
            count += arrList[i].size();
        }
        ArrayList<Integer> res = new ArrayList<>(count);
        for (ArrayList<Integer> list : arrList) {
            res.addAll(list);
        }
        res.sort((a, b) -> a - b);
        return convertRes(res);
    }
}
// @lc code=end
