/**Board.java
  *@author Maguire Marion
  *@version 1.0
  *This program creates a game board
  *made up of cells to be used in a
  *snake game
  */


public class Board { 
    /**Instance Variables:
    *Creates row_count and col_count to set how many rows and columns will be in the board
    *Creates cells as a 2D array filed with type Cell
    *Creates a counter as an initial case for the collection of food
    *Creates score to take over count's job after the first case has been completed */
  
    final int row_count, col_count; 
    private Cell[][] cells; 
    private int counter=0;
    public int score=0;

    /**Constructor accepts two variables as ints
    Sets instance variable row_count and col_count to the parameters rowCount and columnCount respectively
    Sets cells equal to an object of Cell with the total row and column count/board size (ex 10x10 or 15x15)
    For loop to create new cell objects to fill the entire board */
    public Board(int rowCount, int columnCount){ 
        row_count = rowCount; 
        col_count = columnCount; 
        cells = new Cell[row_count][col_count]; 
        for (int row = 0; row < row_count; row++){ 
            for (int column = 0; column < col_count; column++){ 
                cells[row][column] = new Cell(row, column); 
            } 
        } 
    } 
    //returns the current 2D array information
    public Cell[][] getCells() { 
        return cells; 
    } 
    //sets cells within the 2D array
    public void setCells(Cell[][] c){ 
        cells = c; 
    } 

    /** Prints current player score
    Prints "*** Food collected! Snake length increased by 1 ***" every instance after the first, this
    is because food isn't really collected by the user the first time it's generated

    Generates food within a cell by randomly selecting a column and row within range of the board size
    where a current snake node is not at. When a valid cell is found setCellType() is called with the 
    paramater 'CellType.food'
    Prints where the new food is located in the 2D array */

    public void generateFood() { 
        if(counter==0){
            score+=1;
            System.out.println("Score: "+score);
            int row = (int)(Math.random() * row_count); 
            int column = (int)(Math.random() * col_count); 
            cells[row][column].setCellType(CellType.food); 
            System.out.println("Food is generated at: " + row + "," + column);
            counter+=1;
        }
        else{
            score+=1;
            System.out.println("\n"+"*** Food collected! Snake length increased by 1 ***");
            System.out.println("Score: "+score);
            int row = (int)(Math.random() * row_count); 
            int column = (int)(Math.random() * col_count); 
            cells[row][column].setCellType(CellType.food); 
            System.out.println("New food is generated at: " + row + "," + column+"\n");

    } 
        }
} 