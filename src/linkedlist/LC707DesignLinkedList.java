package linkedlist;

class Node{
	int val;
	Node next;

	Node(int val)
	{
		this.val=val;
	}
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

public class LC707DesignLinkedList{
	public static void main(String[] args) {
		
	//	["MyLinkedList","addAtHead","addAtTail","addAtIndex"]
//				[[],[1],[3],[3,2]]
				
		 MyLinkedList obj = new MyLinkedList();
		 obj.addAtHead(1);
		 obj.addAtTail(3);
		 obj.addAtIndex(3,2);

		 
//		 System.out.println(obj.get(0));
		 
		 /*
		 int param_1 = obj.get(index);
		 * 
		 * obj.addAtTail(val);
		 * obj.addAtIndex(index,val);
		 * 
		 * */
	}
}

class MyLinkedList {


	int size;

	Node head;


	public MyLinkedList() {
		this.size=0;
		this.head=null;	
	}

	public int get(int index) {

		if (index < 0 || index >= size) return -1;
		
		
		Node temp=head;

		int count=0;

		while(count<index)
		{
			temp=temp.next;
			count++;
		}

		return temp.val;
	}

	public void addAtHead(int val) {
		Node newNode=new Node(val);

		newNode.next=head;

		head=newNode;

		size++;
	}

	public void addAtTail(int val) {

		Node newNode=new Node(val);

		if(head==null)
		{
			head=newNode;
		}
		else
		{
			Node temp=head;

			while(temp.next!=null)
			{
				temp=temp.next;
			}
	
			temp.next=newNode;
		}
		size++;
	}

	public void addAtIndex(int index, int val) {
		if(index > size) return;

		Node newNode=new Node(val);

		Node temp=head;

		int count=0;

		if(index==0)
		{
			addAtHead(val);
			return;
		}
		else
		{
			while(count+1 < index)
			{
				temp=temp.next;
				count++;
			}
	
			newNode.next=temp.next;
			temp.next=newNode;
		}
		size++;
	}

	public void deleteAtIndex(int index) {

		if(index >= size) return;

		
		if(index==0)
		{
			head=head.next;
		}
		else
		{
			Node temp=head;

			int count=0;
	
			while(count+1 < index)
			{
				temp=temp.next;
				count++;
			}
					
			temp.next=temp.next.next;
		}
		size--;
	}
	
	
}


