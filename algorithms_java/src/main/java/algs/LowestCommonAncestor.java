package algs;

import algs.shared.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LowestCommonAncestor {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> pathP = new LinkedList<>(), pathQ = new LinkedList<>();
        createPath(root, p, pathP); // [2,6]
        createPath(root, q, pathQ); // [8,6]
        int levelP = pathP.size(), levelQ = pathQ.size();
        if(levelP == 0 || levelQ == 0)
            return null;
        while(levelP < levelQ){
            levelQ--;
            pathQ.removeFirst();
        }
        while(levelP > levelQ){
            levelP--;
            pathP.removeFirst();
        }
        while(pathP.getFirst().val != pathQ.getFirst().val){
            pathP.removeFirst();
            pathQ.removeFirst();
        }
        return pathP.getFirst();
    }

    public static boolean createPath(TreeNode current, TreeNode target, List<TreeNode> path){
        if(current == null)
            return false;
        if(target.val == current.val){
            path.add(current);
            return true;
        }
        if((target.val < current.val && createPath(current.left, target, path)) ||
                (target.val >  current.val && createPath(current.right, target, path))){
            path.add(current);
            return true;
        }
        return false;
    }
}
