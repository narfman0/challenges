package shared;

public class Node {
	public String name;
	public Node left, right;

	public Node(String name){
		this.name = name;
	}
	
	public String toString(){
		return name;
	}
}
