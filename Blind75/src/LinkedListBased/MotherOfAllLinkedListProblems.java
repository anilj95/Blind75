package LinkedListBased;

public class MotherOfAllLinkedListProblems {
    // here we are going to cover all LinkedList Problems in one file 
	public static void main(String[] args) {

      ListNode head = new ListNode(1);
      head.next     = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      //head.next.next.next.next = head.next; // creating a cycle
      head.next.next.next.next = new ListNode(5);
      
      // calling function for cycle
      System.out.println(hasCycle(head));
      
   // calling function for findMiddle
      ListNode result = findMiddle(head);
      System.out.println(result.val);
   // calling function for reverse
      System.out.println("List before reversal");
      printList(head);
      ListNode reverse = reverseLinkedList(head);
      System.out.println("List after reversal");
      printList(reverse);
      
 
	}
	
	// Problem 1: check if LinkedList has cycle
	private static boolean hasCycle(ListNode head) {
		
		if(head!= null) {
			
			ListNode slow = head;
			ListNode fast = head;
			
			while( fast.next != null) {
				
				slow = slow.next;
				fast = fast.next.next;
				
				if( slow == fast) {
					return true;
				}
			}
			
		}
		
		return false;
	}
	
	// Problem 2: find middle of LinkedList
		private static ListNode findMiddle(ListNode head) {
	
				ListNode slow = head;
				ListNode fast = head;
				
				while( fast.next != null) {
					
					slow = slow.next;
					fast = fast.next.next;
	
				}

			return slow;
		}
		
	// Problem 3: reverse the LinkedList
	private static ListNode reverseLinkedList(ListNode head) {
		
		ListNode prev = null;
		ListNode curr = head;
		
		while(curr != null) {
			
			ListNode next = curr.next; // saving next node
			curr.next = prev;
			prev = curr;
			curr = next;
			
		}
		
		return prev; // when curr.next -> null, prev is the head now
	}
	
	// Problem 4: merge two sorted list
	 private static ListNode mergeTwoSortedLists(ListNode list1, ListNode list2) {
		 
		 
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	// Base class
	static class ListNode{
		int val;
		ListNode next;
		
		ListNode(int val){
			this.val = val;
			this.next = null;		
		}
	}
	
	//helper function to print the list
	static void printList(ListNode head) {
		while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
	}

}
