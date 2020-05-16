package may_16;

import java.util.Stack;

public class IsPalindrome {
	static class Node {
		int val;
		Node next;
		Node(int val) {
			this.val=val;
		}
	}
	private static boolean isPalindrome(Node head) {
		//if list contains 0 or 1 element, then it's palindrome
		if(head==null || head.next==null)
			return true;
		//find the middle of linked list using slow and fast pointer
		//use a stack to keep track of elements traversed by slow pointer
		Stack<Integer> stack = new Stack<>();
		Node fast=head,slow=head;
		while(fast!=null) {
			fast=fast.next;
			if(fast!=null) {
				fast=fast.next;
			}
			else {
				slow=slow.next;
				break;
			}
			stack.push(slow.val);
			slow=slow.next;
		}
		while(!stack.isEmpty() && slow!=null) {
			if(slow.val!=stack.pop()) {
				return false;
			}
			slow=slow.next;
		}
		return stack.isEmpty();
	}
	

	public static void main(String[] args) {
		Node head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(3);
		head.next.next.next=new Node(2);
		head.next.next.next.next=new Node(2);
		head.next.next.next.next.next=new Node(1);
		System.out.println(isPalindrome(head));

	}

}
