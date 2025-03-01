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
      
   // calling function for merge two list
      ListNode list1 = new ListNode(1);
      list1.next = new ListNode(2);
      list1.next.next = new ListNode(3);
      
      ListNode list2 = new ListNode(1);
      list2.next = new ListNode(3);
      list2.next.next = new ListNode(4);
      System.out.println("Lists before merger");
      printList(list1);
      printList(list2);
      System.out.println("Lists after merger");
      ListNode merged = mergeTwoList(list1,list2);
      printList(merged);
      
      
 
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
	
	
	// Problem 4: merge two sorted Lists
		private static ListNode mergeTwoList(ListNode list1, ListNode list2) {
			
			ListNode dummy = new ListNode(0);
			ListNode curr = dummy;
			
			while(list1 != null && list2 != null) {
				
				if(list1.val < list2.val) {
					
					curr.next = list1;
					list1 = list1.next;
				}else {
					
					curr.next = list2;
					list2 = list2.next;
				}
				
				curr = curr.next;
			}
			
			// if anyone finished earlier
			curr.next = list1 != null? list1 : list2;
			
			return dummy.next;
			
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
