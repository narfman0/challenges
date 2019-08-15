import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class CurrencyTranslate {
    private HashMap<String, Node> currencies = new HashMap<>();

    public class Node{
        public final String symbol;
        public final HashSet<Edge> conversions = new HashSet<>();

        public Node(String symbol){
            this.symbol = symbol;
        }

        public void addConversion(float ratio, String symbol){
            conversions.add(new Edge(ratio, currencies.get(symbol)));
        }
    }
    public class Edge{
        public final float ratio;
        public final Node node;

        public Edge(float ratio, Node node){
            this.ratio = ratio;
            this.node = node;
        }
    }

    public class NodeRatio {
        public final Node node;
        public final float ratio;

        public NodeRatio(float ratio, Node node){
            this.ratio = ratio;
            this.node = node;
        }
    }

    public float currencyTranslate(String symbol1, String symbol2){
        HashSet<Node> visited = new HashSet<>();
        LinkedList<NodeRatio> unvisited = new LinkedList<>();
        unvisited.push(new NodeRatio(1, currencies.get(symbol1)));
        while(!unvisited.isEmpty()){
            NodeRatio current = unvisited.removeFirst();
            visited.add(current.node);
            if(current.node.symbol.equals(symbol2))
                return current.ratio;
            for(Edge edge: current.node.conversions){
                if(!visited.contains(edge.node))
                    unvisited.push(new NodeRatio(edge.ratio * current.ratio, edge.node));
            }
        }
        return -1f;
    }

    @Test
    public void testCurrencyTranslate() {
        currencies.put("USD", new Node("USD"));
        currencies.put("GBP", new Node("GBP"));
        currencies.put("CHN", new Node("CHN"));
        currencies.put("CAD", new Node("CAD"));
        currencies.get("USD").addConversion(0.7f, "GBP");
        currencies.get("USD").addConversion(0.99f, "CAD");
        currencies.get("GBP").addConversion(0.7f, "CHN");
        currencyTranslate("USD", "CHN");
    }
}
