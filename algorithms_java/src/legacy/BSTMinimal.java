class BSTMinimal {
    class Node {
        public int val;
        public Node left, right;

        public Node(int val){
            this.val = val;
        }
    }

    /**
     * Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a binary search tree with minimal height.
     */
    public static Node createBSTBalanced(int[] array) {
        return createBSTBalancedNode(array, 0, array.length-1);
    }

    private static Node createBSTBalancedNode(int[] array, int l, int r) {
        if(r < l)
            return null;
        int m = (r-l)/2;
        Node node = new Node(array[m]);
        if(l < m)
            node.left = createBSTBalancedNode(array, l, m-1);
        if(m < r)
            node.right = createBSTBalancedNode(array, m+1, r);
        return node;
    }
}
