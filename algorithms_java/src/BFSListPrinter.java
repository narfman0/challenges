import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import shared.Node;

public class BFSListPrinter {
	public static List<List<Node>> createNodesPerDepth(Node root){
		List<List<Node>> lists = new LinkedList<>();
		List<Node> next = new LinkedList<>();
		next.add(root);
		while(!next.isEmpty()){
			lists.add(new ArrayList<>(next));
			List<Node> toIterate = new ArrayList<>(next);
			next.clear();
			for(Node current : toIterate){
				if(current.left != null)
					next.add(current.left);
				if(current.right != null)
					next.add(current.right);
			}
		}
		return lists;
	}
	
	public static void main(String[] args) {
		Node root = new Node("4");
		root.left = new Node("2");
		root.left.left = new Node("1");
		root.left.right = new Node("3");
		root.right = new Node("6");
		root.right.left = new Node("5");
		root.right.right = new Node("7");
		
		List<List<Node>> result = createNodesPerDepth(root); 
		System.out.println(result);
	}
}
