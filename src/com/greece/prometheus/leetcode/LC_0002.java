package com.greece.prometheus.leetcode;

public class LC_0002 {

	public static void main(String[] args) {
		LC_0002 me = new LC_0002();
		int nums[] = {2, 6, 7, 3, 5, 0, 9};
		ListNode head = me.createListFromArray(nums);
		head = me.reverseList(head);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}

	}
	
	class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode p = l1, q = l2, curr = head;
		int carry = 0;
		while (p != null || q != null) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if (p != null) {
				p = p.next;
			}
			if (q != null) {
				q = q.next;
			}
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return head.next;
	}

	public ListNode createListFromArray(int nums[]) {
		ListNode head = new ListNode(0);
		ListNode curr = head;
		for (int i = 0; i < nums.length; i++) {
			curr.next = new ListNode(nums[i]);
			curr = curr.next;
		}
		return head.next;
	}
	
	public ListNode reverseList(ListNode h){
        if (h == null) return null;
        ListNode pre = null;
        ListNode next;
        while (h != null) {
        	next = h.next;
        	h.next = pre;
        	pre = h;
        	h = next;
        }
        return pre;
    }
	
	public ListNode reverseListRecursion(ListNode h) {
		// 
		ListNode newH;
		if (h == null || h.next == null) {
			return h;
		}
		newH = reverseListRecursion(h.next);
		h.next.next = h;
		h.next = null;
		return newH;
	}
}
