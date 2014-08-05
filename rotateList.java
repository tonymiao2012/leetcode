package leetcode;

public class rotateList {
	/**
	 * Definition for singly-linked list. public class ListNode { int val;
	 * ListNode next; ListNode(int x) { val = x; next = null; } }
	 */
	public static ListNode rotateRight(ListNode head, int n) {
		// judge list first
		if (head == null) {
			return null;
		}
		// get tail and length of list first.
		int length = 1;
		ListNode tail = head;
		while (tail.next != null) {
			tail = tail.next;
			length++;
		}
		int target = length - n % length;
		tail.next = head;
		for (int i = 0; i < target; i++) {
			tail = tail.next;
		}
		head = tail.next;
		tail.next = null;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode n1 = new ListNode(2);
		head.next = n1;
		ListNode n2 = new ListNode(3);
		n1.next = n2;
		ListNode n3 = new ListNode(4);
		n2.next = n3;
		ListNode n4 = new ListNode(5);
		n3.next = n4;
		// removeDuplateListNode.deleteDuplicates(head);
		ListNode index = rotateList.rotateRight(head, 2);
		// ListNode index = head;
		while (index != null) {
			System.out.println(index.val);
			index = index.next;
		}
	}

}
