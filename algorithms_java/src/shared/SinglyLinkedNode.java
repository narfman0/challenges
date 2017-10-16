package shared;

public class SinglyLinkedNode {
	public int val;
	public SinglyLinkedNode next;
	
	public SinglyLinkedNode(int x) {
		val = x;
		next = null;
	}
	
	@Override public String toString(){
		return val + "";
	}
	
	public int length(){
		if(next == null)
			return 0;
		return 1 + next.length();
	}
}
