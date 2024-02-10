/**
 * 
 */
package com.middleLevel;

import java.util.Iterator;

/**
 * 
 */
public class AddTwoNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] firstNumberArray = { 9, 9, 9, 9, 9, 9, 9 };
		int[] secondNumberArray = { 9, 9, 9, 9 };

		ListNode firstNumbersArrayFirstPointer = arrayToListNode(firstNumberArray);
		ListNode secondNumbersArrayFirstPointer = arrayToListNode(secondNumberArray);

		ListNode resultListNode = addTwoNumbers(firstNumbersArrayFirstPointer, secondNumbersArrayFirstPointer);
		
		while (resultListNode != null) {
			System.out.print(resultListNode.val + " ");
			resultListNode = resultListNode.next;
		}
		System.out.println();
	}

	private static ListNode arrayToListNode(int[] array) {
		if (array.length == 0) {
			return null;
		}
		ListNode head = new ListNode(array[0]);
		ListNode current = head;
		for (int i = 1; i < array.length; i++) {
			current.next = new ListNode(array[i]);
			// only referencing/pointer update(switch), not class's field values
			current = current.next;
		}
		return head;
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// Traversing of a Linked List
		ListNode dummyListNode = new ListNode();
		dummyListNode.next = new ListNode();
		ListNode resultListNode = dummyListNode.next;
		int carry = 0;
		
		if (l1 != null && l2 != null) {
			// Even if the 'val' of l1 or l2 is not explicitly assigned, it is initialized
			// to 0 by default, provided that the ListNode class has been instantiated.
			resultListNode.val = (l1.val + l2.val) % 10;
			carry = (l1.val + l2.val) / 10;

			while (l1.next != null || l2.next != null) {
				resultListNode.next = new ListNode();
				resultListNode = resultListNode.next;
				// mod operator for resultListNode val and division operator for carry
				if (l1.next != null && l2.next == null) {
					l1 = l1.next;
					resultListNode.val = (carry + l1.val) % 10;
					carry = (carry + l1.val) / 10;

				} else if (l1.next == null && l2.next != null) {
					l2 = l2.next;
					resultListNode.val = (carry + l2.val) % 10;
					carry = (carry + l2.val) / 10;

				} else {
					l1 = l1.next;
					l2 = l2.next;
					resultListNode.val = (carry + l1.val + l2.val) % 10;
					carry = (carry + l1.val + l2.val) / 10;
				}
			}
			if (carry != 0) {
				resultListNode.next = new ListNode();
				resultListNode = resultListNode.next;
				resultListNode.val = carry;
			}
		}
		return dummyListNode.next;
	}
}
