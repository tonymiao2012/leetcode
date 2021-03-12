package leetcode;

public class removeDuplateListNode {
	public static ListNode deleteDuplicates(ListNode head) {
		// check first.
		if (head == null) {
			return null;
		}
		ListNode pre = head;
		ListNode cur = head.next;
		while (cur != null) {
			// find duplicates.
			if (pre.val == cur.val) {
				pre.next = cur.next;
				cur = cur.next;
			} else {
				pre = cur;
				cur = cur.next;
			}
		}
		return head;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode n1 = new ListNode(1);
		head.next = n1;
		ListNode n2 = new ListNode(2);
		n1.next = n2;
		ListNode n3 = new ListNode(3);
		n2.next = n3;
		ListNode n4 = new ListNode(3);
		n3.next = n4;
		removeDuplateListNode.deleteDuplicates(head);
		ListNode index = head;
		while (index != null) {
			System.out.println(index.val);
			index = index.next;
		}

	}

}
