/**Snake.java
  *@author Maguire Marion
  *@version 1.0
  *This program creates a linked list and
  *methods to alter the linked list to
  *represent a 'snake' for a snake game
 */

import java.util.LinkedList; 
  
public class Snake{ 
    /** Instance Variables:
    *Creates snakePartList; a linked list full of type cell to act as the snake and its position/parts 
    *in the 2D Array.
    *Creates 'head' of type Cell to denote where the front node of the snake is, used since movement is 
    *based on the snakes head location */
  
    private LinkedList<Cell> snakePartList = new LinkedList<>(); 
    private Cell head; 

    /**Constructor accepts one variable of type Cell
    *Sets instance variable head equal to initial position in the board (0,0 in this
    *game but it can techncially be whatever)
    *Adds a 'head' to the linked list to intialize the snake as one node 
    * @param initPos used to set head and add node */
    public Snake(Cell initPos){ 
        head = initPos; 
        snakePartList.add(head); 
    } 
    /**adds a 'head' to the linked list to increase snake length */
    public void grow(){ 
        snakePartList.add(head); 
    } 
    /** Prints what cell the snake is moving to
    *Removes 'tail' node by setting that cell to empty and adds a 'head' to the 
    *front of the linked list to simulate it moving one space 
    * @param nextCell used to set head and obtain row and col of next cell */
    public void move(Cell nextCell){ 
        System.out.println("Snake is moving to " + nextCell.getRow() + "," + nextCell.getCol()); 
        Cell tail = snakePartList.removeLast(); 
        tail.setCellType(CellType.empty); 
        head = nextCell; 
        snakePartList.addFirst(head); 
    } 
    
    /**For each loop that checks for each cell in the linked list, if the next cell (the one
    *the snake is moving to) is equal to current 'for' cell, thus meaning the snake ran into
    *itself, returning true 
    * @param nextCell used to compare to cell */
    public boolean checkCrash(Cell nextCell){ 
        for (Cell cell : snakePartList){ 
            if (cell == nextCell){ 
                return true; 
            } 
        } 
        return false; 
    } 
  
    /** returns the linked list */
    public LinkedList<Cell> getSnakePartList(){ 
        return snakePartList; 
    } 
    /**sets snakePartList, the linked list, to snp
    * @param snp sets snakePartList to snp */
    public void setSnakePartList(LinkedList<Cell> snp){ 
        snakePartList = snp; 
    } 
    /**returns the current head node as which Cell it's in */
    public Cell getHead(){ 
        return head; 
    } 
    /**sets the head node of the linked list at a certain cell
    *@param h sets head equal to h */
    public void setHead(Cell h){ 
        head = h; 
    } 
} 