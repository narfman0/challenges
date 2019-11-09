package algs;

import java.util.HashMap;

public class KnightProbability {

    private static class Move {
        public int r, c;

        public Move(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    private static Move[] moves = new Move[]{
            new Move(2, 1),
            new Move(1, 2),
            new Move(-1, 2),
            new Move(-2, 1),
            new Move(-2, -1),
            new Move(-1, -2),
            new Move(1, -2),
            new Move(2, -1)
    };

    public static double knightProbability(int N, int K, int r, int c) {
        return knightProbability(N, K, r, c, 1.0, new HashMap<>());
    }

    public static double knightProbability(int N, int K, int r, int c, double p, HashMap<String, Double> m) {
        if(r < 0 || c < 0 || r >= N || c >= N)
            return 0.0;
        if(K == 0)
            return p;

        Double currentP = m.get(K + "," + r + "," + c);
        if(currentP != null)
            return currentP;

        currentP = 0.0;
        double childP = p/8.0;
        for(Move move: moves)
            currentP += knightProbability(N, K-1, r+move.r, c+move.c, childP, m);
        m.put(K + "," + r + "," + c, currentP);
        return currentP;
    }
}
