package linkedlist.twopointer;

import java.util.HashSet;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class LC160IntersectionofTwoLinkedLists {

	public static void main(String[] args) {
		 // Common tail: 8 → 4 → 5
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        // listA: 4 → 1 → (8 → 4 → 5)
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;

        // listB: 5 → 6 → 1 → (8 → 4 → 5)
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;

        LC160IntersectionofTwoLinkedLists sol=new LC160IntersectionofTwoLinkedLists();
        
        ListNode intersectionNode=sol.getIntersectionNodeBF(headA, headB);

        System.out.println(intersectionNode.val);

        System.out.println(intersectionNode.next.val);

        System.out.println(intersectionNode.next.next.val);
        
	}

	
	private ListNode getIntersectionNodeBF(ListNode headA, ListNode headB) {
		
		ListNode tempA=headA;
		
		
		while(tempA!=null)
		{
			ListNode tempB=headB;

			while(tempB!=null)
			{
				if(tempA==tempB)
					return tempA;
				
				tempB=tempB.next;
			}
			tempA=tempA.next;
		}
		
		return null;
	}


	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		HashSet<ListNode> set=new HashSet<>();
		
		ListNode tempA=headA;
		ListNode tempB=headB;
		
		
		while(tempA!=null)
		{
			set.add(tempA);
			tempA=tempA.next;
		}
		
		while(tempB!=null)
		{
			if(set.contains(tempB))
				return tempB;
			
			tempB=tempB.next;
		}
		
		return null;
	}
}
