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
		
		int[] firstNumberArray = {9,9,9,9,9,9,9};
		int[] secondNumberArray = {9,9,9,9};
		
		ListNode firstNumbersArrayFirstPointer = arrayToListNode(firstNumberArray);
		ListNode secondNumbersArrayFirstPointer = arrayToListNode(secondNumberArray);
		
	}
	private static ListNode arrayToListNode(int[] array) {
		if(array.length == 0) { return null; }
		ListNode head = new ListNode(array[0]);
		ListNode current = head;
		for (int i = 0; i < array.length; i++) {
			current.next = new ListNode(array[i]);
			//only referencing/pointer update(switch), not class's field values
			current = current.next;
		}
		return head;
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		   
    }


}
