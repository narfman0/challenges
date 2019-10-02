/**
 * Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
 * column are set to 0.
 */
public void applyZeroRowColumns(int[][] matrix){
    // gather 0 x,y points
    HashSet<Integer> zeroColumns = new HashSet<>(),
        zeroRows = new HashSet<>();
    for(int y = 0; y<matrix.length; y++)
        for(int x = 0; x<matrix[y].length; y++)
            if(matrix[y][x] == 0){
                zeroColumns.add(x);
                zeroRows.add(y);
            }
    // apply 0s to rows and columns
    for(int column : zeroColumns)
        for(int y=0; y<matrix.length; y++)
            matrix[y][column] = 0;
    for(int row : zeroRow)
        for(int x=0; x<matrix[column].length; x++)
            matrix[x][row] = 0;
    return;
}
