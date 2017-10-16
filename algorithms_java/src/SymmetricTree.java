import java.util.Stack;

import shared.TreeNode;

public class SymmetricTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		assert(1 == isSymmetric(root));
	}

	public static int isSymmetric(TreeNode a) {
		Stack<Integer> order = new Stack<>();
	    postOrder(order, a);
	    return comparePreOrder(order, a) ? 1 : 0;
	}

	/**
	 *  perform pre order traversal, popping comparisons from list
	 */
	private static boolean comparePreOrder(Stack<Integer> list, TreeNode a){
		if(a == null)
			return true;
		if(list.pop() != a.val)
			return false;
		return comparePreOrder(list, a.left) && comparePreOrder(list, a.right);
	}

	/**
	 *  perform post order traversal, push'ing results to list
	 */
	private static void postOrder(Stack<Integer> list, TreeNode a){
		if(a == null)
			return;
		postOrder(list, a.left);
		postOrder(list, a.right);
		list.push(a.val);
	}
}
