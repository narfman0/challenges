package algs;

import java.util.HashMap;

public class KnightProbability {
    private static int[] mr = {2, 1, -1, -2, -2, -1, 1, 2},
            mc = {1, 2, 2, 1, -1, -2, -2, -1};

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
        for(int i=0; i<mr.length; i++)
            currentP += knightProbability(N, K-1, r+mr[i], c+mc[i], childP, m);
        m.put(K + "," + r + "," + c, currentP);
        return currentP;
    }
}
