package algs;

import java.util.LinkedList;
import java.util.List;

public class SpiralOrder {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        for(int i=0; i<=matrix.length/2; i++)
            spiral(matrix, result, i);
        return result;
    }

    public static void spiral(int[][] matrix, List<Integer> result, int spiral){
        int direction = 1;
        int y=spiral, x=spiral;
        while(true){
            result.add(matrix[y][x]);
            switch(direction){
                case 0:
                    if(y == spiral)
                        return;
                    else
                        y--;
                    break;
                case 1:
                    if(x == matrix[y].length-1-spiral){
                        direction=2;
                        y++;
                    }else
                        x++;
                    break;
                case 2:
                    if(y == matrix.length-1-spiral){
                        direction = 3;
                        x--;
                    }else
                        y++;
                    break;
                case 3:
                    if(x == spiral){
                        direction = 0;
                        y--;
                    }else
                        x--;
                    break;
            }
        }
    }
}
