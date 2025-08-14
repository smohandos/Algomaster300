package linkedlist.twopointer;

/*
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}
*/

public class LC19RemoveNthNodeFromEndofList {

	/*
	 * Input: head = [1,2,3,4,5], n = 2
	Output: [1,2,3,5]
	Example 2:

	Input: head = [1], n = 1
	Output: []
	Example 3:

	Input: head = [1,2], n = 1
	Output: [1]
	 */
	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		/*
		head.next.next=new ListNode(3);
		head.next.next.next=new ListNode(4);
		head.next.next.next.next=new ListNode(5);
		 */
		LC19RemoveNthNodeFromEndofList sol=new LC19RemoveNthNodeFromEndofList();
		ListNode res=sol.removeNthFromEndOpt(head, 1);

		while(res!=null)
		{
			System.out.println(res.val);
			res=res.next;
		}

	}

	public ListNode removeNthFromEnd(ListNode head, int n) {

		int total=0;

		ListNode temp=head;

		while(temp!=null)
		{
			total++;
			temp=temp.next;
		}

		temp=head;

		if(total==n)
		{
			head=head.next;
			return head;
		}

		int count=1;

		while(count<(total-n))
		{
			temp=temp.next;
			count++;
		}

		temp.next=temp.next.next;

		return head;
	}

	public ListNode removeNthFromEndOpt(ListNode head, int n) {
		
		ListNode slow=head;
		
		ListNode fast=head;
		
		int count=0;
		
		while(count<n)
		{
			fast=fast.next;
			count++;
		}
		
		while(fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next;
		}
		
		
		
		return head;
	}

}
