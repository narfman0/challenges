import shared.SinglyLinkedNode;

public class DeleteDuplicates {
	public static void main(String[] args) {
		SinglyLinkedNode root = new SinglyLinkedNode(1);
		root.next = new SinglyLinkedNode(2);
		root.next.next = new SinglyLinkedNode(3);
		root.next.next.next = new SinglyLinkedNode(4);
		root.next.next.next.next = new SinglyLinkedNode(4);
		root.next.next.next.next.next = new SinglyLinkedNode(4);
		root.next.next.next.next.next.next = new SinglyLinkedNode(5);
		deleteDuplicates(root);
		
		assert(5 == root.length());
	}

	
	public static SinglyLinkedNode deleteDuplicates(SinglyLinkedNode a) {
		SinglyLinkedNode current = a;
		while(current.next != null){
			if(current.val == current.next.val)
				current.next = current.next.next;
			else
				current = current.next;
		}
		return a;
	}
}
