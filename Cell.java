/**Cell.java
  *@author Maguire Marion
  *@version 1.0
  *This program defines what makes
  *up a cell for a snake fame and allows 
  *for alterations to their type and attributes
  */


public class Cell{ 
    /** Instance Variables:
    Creates a row and col as ints to determine where in the 2D array a specific Cell exists
    Creates a cellType of type CellType to determine what kind of cell a specific cell is (a cell 
    filled with food, a cell filled with a snake node, or empty) */
  
    private final int row, col; 
    private CellType cellType; 

    /*Constructor accepts two variables as ints, r and c, to establish where in the 2D array as
    row and column
    The constructor also sets the row and column to r and c respectively */
    public Cell(int r, int c){ 
        row = r; 
        col = c; 
    } 
    //returns the type of cell a specific cell is (a cell filled with food, a cell filled with a snake node, or empty)
    public CellType getCellType(){ 
        return cellType; 
    } 
    //sets the type of cell a specific cell is to be (a cell filled with food, a cell filled with a snake node, or empty)
    public void setCellType(CellType ct){ 
        cellType = ct; 
    } 
    //returns the row of a specific cell as an int
    public int getRow(){ 
        return row; 
    } 
    //returns the column of a specific cell as an int
    public int getCol(){ 
        return col; 
    } 
} 