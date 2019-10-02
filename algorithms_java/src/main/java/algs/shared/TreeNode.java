package algs.shared;

public class TreeNode {
	public String name;
	public TreeNode left, right;

	public TreeNode(String name){
		this.name = name;
	}
	
	public String toString(){
		return name;
	}
}
