package algs.shared;

public class TreeNode {
	public String name;
	public int val;
	public TreeNode left, right;

	public TreeNode(String name){
		this.name = name;
	}

	public TreeNode(int val){
		this.val = val;
	}
	
	public String toString(){
		return name + "," + val;
	}
}
