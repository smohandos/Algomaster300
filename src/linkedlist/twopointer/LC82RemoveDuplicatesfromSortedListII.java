package linkedlist.twopointer;

import java.util.HashMap;
import java.util.Map;


public class LC82RemoveDuplicatesfromSortedListII {
	/*
	 * Example 1:

	Input: head = [1,2,3,3,4,4,5]
	Output: [1,2,5]
	Example 2:
	
	
	Input: head = [1,1,1,2,3]
	Output: [2,3]

	*/
	public static void main(String[] args) {
		LC82RemoveDuplicatesfromSortedListII sol=new LC82RemoveDuplicatesfromSortedListII();
		
		ListNode head = new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(3);
		head.next.next.next=new ListNode(3);
		head.next.next.next.next=new ListNode(4);
		head.next.next.next.next.next=new ListNode(4);
		head.next.next.next.next.next.next=new ListNode(5);

		//,2,3,3,4,4,5;
		ListNode res=sol.deleteDuplicates(head);
		
		
		while(res!=null)
		{
			System.out.println(res.val);
			res=res.next;
		}
		
	}

	public ListNode deleteDuplicatesBF(ListNode head) {
		ListNode curr=head;
		
		Map<Integer, Integer> map=new HashMap<>();
		
		while(curr!=null)
		{
			map.put(curr.val, map.getOrDefault(curr.val, 0)+1);
		}
		
		
		ListNode dummy=new ListNode(0);
		
		dummy.next=head;
		
		curr=head;
		
		ListNode tail = dummy;
				
		while(curr!=null)
		{
			if(map.get(curr.val)==1)
			{
				tail.next=curr;
			}
			
			curr=curr.next;
		}
		
		return dummy.next;
	}
	
	public ListNode deleteDuplicates(ListNode head) {
	    // 'prev' points to the last node in the result list
	    ListNode prev = null;
	    // 'curr' is the current node being processed
	    ListNode curr = head;
	            
	    // Traverse the entire list
	    while (curr != null) {
	        // Case 1: Duplicate sequence found
	        if (curr.next != null && curr.val == curr.next.val) {
	            // Store the duplicate value to skip all its occurrences
	            int val = curr.val;
	            
	            // Skip all nodes with the duplicate value
	            while (curr != null && curr.val == val)
	                curr = curr.next;
	            
	            // If there is a previous node, link it to the node after the duplicates
	            if (prev != null)
	                prev.next = curr;
	            else
	                // If duplicates were at the start, move the head forward
	                head = curr;    
	        } 
	        else {
	            // Case 2: Current node is unique — include it in the result
	            prev = curr;        // Move 'prev' forward
	            curr = curr.next;   // Move 'curr' forward
	        }
	    }
	    return head;
	}

}
