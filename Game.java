/**Game.java
  *@author Maguire Marion
  *@version 1.0
  *This program allows user input
  *to play a game of snake
 */

import java.util.Scanner;

public class Game{
    /** Instance Variables:
    *Sets directions as integers to be referred to later
    *Creates snake variable of type Snake class
    *Creates board variable of type Board class
    *Creates direction as an int to be compared to direction_none, direction_right, etc
    *Creates gameOver as a boolean value to determine whether game is over or not
    *Creates dir(ection) as a string; used for printing current direction snake is facing
    *Creates u(ser-inputed)dir(ection) as a string for conversion later
    *Creates c(onverted)dir(ection) as an int to convert udir to an int to be used */
  
    public static final int direction_none = 0, direction_right = 1, direction_left = -1, direction_up = 2, direction_down = -2;
    private Snake snake;
    private Board board;
    private int direction;   
    private boolean gameOver;
    private static String dir;
    private static String udir;
    private static int cdir;
  

    /**Constructor accepts two variables of type Snake and Board, both used for the game
    * @param s instance variable sets snake equal to s
    * @param b instance variable sets board equal to b */
    public Game(Snake s, Board b){
        snake = s;       
        board = b; 
    } 
  
    /**returns snake information as type Snake */
    public Snake getSnake(){ 
        return snake; 
    } 
    /**sets snake location as s */
    public void setSnake(Snake s){ 
        snake = s; 
    } 
    /**returns board information as type Board */
    public Board getBoard(){ 
        return board; 
    } 
    /**sets snake location as b */
    public void setBoard(Board b){ 
        board = b; 
    }
    /* retuns boolean if game is over or not */
    public boolean isGameOver(){ 
        return gameOver; 
    } 
    //sets snake location as s
    public void setGameOver(boolean go){ 
        gameOver = go; 
    } 
    //retuns boolean if game is over or not
    public int getDirection(){ 
        return direction; 
    } 
    //sets direction to dir as an int
    public void setDirection(int dir){ 
        direction = dir; 
    } 

    /** Function to 'update' the game as it's played; called after every user input
    *Sets the direction, moves the snake
    *Checks if snake has crashed; if it has, prints final score and ends game
    *Checks if snake has moved to a cell with food and increaes length if it has */
    public void update(){ 
        if (!gameOver){ 
            if (direction != direction_none){ 
                Cell nextCell = getNextCell(snake.getHead()); 
  
                if (snake.checkCrash(nextCell)){ 
                    setDirection(direction_none);
                    System.out.println("\n"+" *** Crash into self ***");
                    System.out.println("     Final Score: "+board.score);
                    System.out.println("     ***GAME OVER***"+"\n");
                    gameOver = true; 
                } 
                else{ 
                    snake.move(nextCell); 
                    if (nextCell.getCellType() == CellType.food){ 
                        snake.grow(); 
                        board.generateFood(); 
                    } 
                } 
            } 
        } 
        else{
            setDirection(direction_none);
            System.out.println("\n"+" *** Crash into wall ***");
            System.out.println("     Final Score: "+board.score);
            System.out.println("     ***GAME OVER***"+"\n");
            System.exit(0);

        }
    } 
    /** Checks the next cell the snake will enter after a user input
       *Returns information about the cell being moved to unless the 
       *index is out of bounds; then that means snake has crashed into a wall
       *and the game ends 
       * @param currentPosition instance variable used ot get current row and col of snake */
    private Cell getNextCell(Cell currentPosition){ 
        Cell nextCell = board.getCells()[0][0];
        int row = currentPosition.getRow(); 
        int col = currentPosition.getCol(); 
  
        if (direction == direction_right){ 
            col++; 
        } 
        else if (direction == direction_left){ 
            col--; 
        } 
        else if (direction == direction_up){ 
            row--; 
        } 
        else if (direction == direction_down){ 
            row++; 
        } 

        try{
            nextCell = board.getCells()[row][col]; 
            return nextCell;
        }catch(ArrayIndexOutOfBoundsException e){
            gameOver=true;
            update();
        }

        return null; 
    } 
  
      /**Starts game by intitializing object of class Cell, Snake, Board and Game
        Prints instructions on how to play
        Initializes snake direction to right, and generates food
        Starts game while gameOver is equal to false
        Prints current snake direction (before every move)
        Accepts user input as R, L, U, D (Right, Left, Up, Down) to move direction 
        Calls update() after every user input to do logic of the move, check for crashes, change variables, etc 
        While loop repeats while gameOver is equal to false */

    public static void main(String[] args){ 

        Scanner input = new Scanner(System.in);
  
        System.out.println("*** Game starting ***");
        Cell initPos = new Cell(0, 0);
        Snake initSnake = new Snake(initPos);
        Board board = new Board(11, 11);
        System.out.println("INSTRUCTIONS:"+"\n"+"You will control a snake with the objective of navigating to and collecting food"+"\n"+"As the snake gathers food, it will increase its length by 1 every time food is collected"+"\n"+"If the snake runs into a wall, or crashes into itself, the game is over"+"\n"+"The snake is controlled by R, L, U, D for Right, Left, Up, and Down respectively"+"\n");

        System.out.println("Snake initialized at 0,0 in a 10x10 board"); 
        Game newGame = new Game(initSnake, board); 
        newGame.gameOver = false; 
        newGame.direction = direction_right;
        newGame.board.generateFood(); 

        while(newGame.gameOver == false){
            if(newGame.direction==1)
                dir="right";
            else if(newGame.direction==-1)
                dir="left";
            else if(newGame.direction==-2)
                dir="up";
            else
                dir="down";
            
            if(newGame.direction!=0){
                System.out.println("You are currently facing "+dir);
            }
            System.out.println("Enter a direction to turn and move:");
            udir=input.nextLine();
            if(udir.equalsIgnoreCase("R")){
                cdir=1;
                newGame.setDirection(cdir);
            }
            else if(udir.equalsIgnoreCase("L")){
                cdir=-1;
                newGame.setDirection(cdir);
            }
            else if(udir.equalsIgnoreCase("D")){
                cdir=2;
                newGame.setDirection(cdir);
            }
            else if(udir.equalsIgnoreCase("U")){
                cdir=-2;
                newGame.setDirection(cdir);
            }
            else{
                 System.out.println("Not a valid entry; snake not moved");
                 System.out.println("Reminder: R=Right, L=Left, U=Up, D=Down");
                 cdir=0;
                 newGame.setDirection(cdir);
            }

            newGame.update();

        }
    } 
}

