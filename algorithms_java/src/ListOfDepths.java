import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class ListOfDepths {
    class Node {
        Node left, right;
    }

    public static List<LinkedList<Node>> listOfDepths(Node root){
        ArrayList<LinkedList<Node>> result = new ArrayList<>();
        listOfDepths(result, root, 0);
        return result;
    }

    private static void listOfDepths(ArrayList<LinkedList<Node>> result, Node node, int level){
        if(node == null)
            return;
        while(result.size() == level)
            result.add(new LinkedList<>());
        result.get(level).add(node);
        listOfDepths(result, node.left, level+1);
        listOfDepths(result, node.right, level+1);
    }
}
