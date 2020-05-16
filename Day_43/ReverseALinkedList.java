package may_16;

class Node {
	int val;
	Node next;
	Node(int val) {
		
		this.val=val;
		this.next=null;
	}
}

public class ReverseLinkedList {
	
	private static Node reverseList(Node head) {
		//if list contains 0 or 1 element, no need to reverse
		if(head==null || head.next==null)
			return head;
		//take 3 pointers, prev, curr and next
		Node prev=null,curr=head,next=null;
		while(curr!=null) {
			//first save the next of curr
			next=curr.next;
			//reverse the current node
			curr.next=prev;
			//move ahead prev and curr pointers
			prev=curr;
			curr=next;
		}
		//prev will be pointing to first node in reversed list
		head=prev;
		return head;
		
	}
	
	private static Node reverseListRec(Node head) {
		//if list contains 0 or 1 element, no need to reverse
		if(head==null || head.next==null)
			return head;
		Node rest = reverseListRec(head.next);
		head.next.next=head;//this is the tricky step which does the reversal
		head.next=null;
		return rest;
	}
	
	private static void display(Node head) {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.val+" ");
			temp=temp.next;
		}
	}

	public static void main(String[] args) {
		Node head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(3);
		head.next.next.next=new Node(4);
		head=reverseListRec(head);
		display(head);

	}

}
