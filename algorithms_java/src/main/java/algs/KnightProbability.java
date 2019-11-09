package algs;

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
        return knightProbability(N, K, r, c, 1.0);
    }

    public static double knightProbability(int N, int K, int r, int c, double p) {
        if(r < 0 || c < 0 || r >= N || c >= N)
            return 0.0;
        if(K == 0)
            return p;
        double currentP = 0.0, childP = p/8.0;
        for(Move move: moves)
            currentP += knightProbability(N, K-1, r+move.r, c+move.c, childP);
        return currentP;
    }
}
