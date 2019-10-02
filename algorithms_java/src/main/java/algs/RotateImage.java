package algs;

class RotateImage {
    public static void rotate(int[][] matrix) {
        for(int y=0; y<matrix.length/2; y++)
            for(int x=y; x<matrix[y].length - y - 1; x++){
                // store the top left corner
                int temp = matrix[y][x];
                // rotate bottom left into top left
                matrix[y][x] = matrix[matrix.length-x-1][y];
                // rotate bottom right into bottom left
                matrix[matrix.length-x-1][y] = matrix[matrix.length-y-1][matrix.length-x-1];
                // rotate top right into bottom right
                matrix[matrix.length-y-1][matrix.length-x-1] = matrix[x][matrix.length-y-1];
                // rotate top left (temp) into top right
                matrix[x][matrix.length-y-1] = temp;
            }
    }
}