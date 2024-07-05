package algs;

import algs.shared.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLowestCommonAncestor {
    @Test
    public void testLCA(){
        TreeNode root = new TreeNode(6), p, q;
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        TreeNode result = LowestCommonAncestor.lowestCommonAncestor(root, root.left, root.right);
        assertEquals(root.val, result.val);
    }
}
