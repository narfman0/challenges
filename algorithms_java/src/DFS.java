class DFS {
    class Node {
        public String val;

        public node(String val){
            this.val = val;
        }
    }

    public Graph {
        public final List<Node> nodes = new LinkedList<>();
        public final HashMap<Node, Node> edges = new HashMap<>();

        public void addNode(Node node){
            nodes.add(node);
        }

        public void addEdge(Node start, Node end){
            edges.put(start, end);
        }

        /**
         * Determine if there is a path from start to end and end to start
         */
        public boolean symmetricPathExists(Node start, Node end){
            return pathExists(start, end, new HashSet<Node>()) && pathExists(end, start, new HashSet<>());
        }

        public boolean pathExists(Node start, Node end, HashSet<Node> visited){
            if(start == null)
                return false;
            if(start == end)
                return true;
            for(Node adjacent: edges.get(start)){
                if(!visited.contains(adjacent)){
                    visited.add(adjacent);
                    pathExists(adjacent, end);
                }
            }
            return false;
        }
    }
}
