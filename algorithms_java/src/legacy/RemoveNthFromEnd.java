public class RemoveNthFromEnd {
	public static SinglyLinkedNode removeNthFromEnd(SinglyLinkedNode a, int b) {
	    if(a == null)
	        return a;

	    SinglyLinkedNode current = a;
	    int length = 1;
	    while(current.next != null){
	        current = current.next;
	        length++;
	    }
	    if(length <= b)
	        return a.next;
	    current = a;
	    for(int i=0; i<length-1-b; i++)
	        current = current.next;
	    current.next = current.next.next;
	    return a;
	}

	public static void main(String[] args) {
		{
			SinglyLinkedNode a = new SinglyLinkedNode(5);
			a.next = new SinglyLinkedNode(1);
			a.next.next = new SinglyLinkedNode(2);
			a.next.next.next = new SinglyLinkedNode(3);
			a.next.next.next.next = new SinglyLinkedNode(4);
			a.next.next.next.next.next = new SinglyLinkedNode(5);
			removeNthFromEnd(a, 1);
			int count = 0;
			for(SinglyLinkedNode current=a; current != null; current = current.next){
				System.out.println(current.val);
				count++;
			}
			assert(count == 5);
		}
	}
}
