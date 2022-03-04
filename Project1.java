import java.util.Scanner;
import java.util.Random;
/**
 * See the project description for details about what is expected
 * for the methods outlind below.
 *
 * @author Samuel Ayoade & Keith Thoong
 * @version Thursday March 4th, 2022
 */
public class Project1 {

    // This is the ONLY private data you may have:
    /**
     * Global counter used to uniquely label triominos
     */ 
    private static int counter = 1;  

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        System.out.println("!! Welcome to Project 1 !!");

        System.out.print("Enter exponent: ");
        int exp = in.nextInt();

        // Your code goes here.
        int[][] board = getRandomBoard(exp);
        printBoard(board);
        tileCheckerboardRec(board);
        System.out.println("\n");
        printBoard(board);

        System.out.println("Done. Normal termination.");
    }
    /**
     * Generates a randomboard sized exp by exp.
     *
     * @param exp Takes in user's exponent
     * @return returns user 2d generated board
     */
    public static int[][] getRandomBoard(int exp) {
        Random rand = new Random();

        // Your code goes here.
        int boardSize = (int)(Math.pow(2,exp));
        int[][] randomBoard = new int[boardSize][boardSize];
        
        randomBoard[rand.nextInt(boardSize)][rand.nextInt(boardSize)] = 1;

        // Don't forget to increment counter in here.
        counter++;
        return randomBoard;
    }
    /**
     * Prints Random generated boar
     *
     * @param board the random generated board
     */
    public static void printBoard(int[][] board) {
        // Your code goes here.
        int width = Math.max((counter / 10), 1);
        for(int i = 0; i < board.length; i++){
            printBorders(board);

            for(int j = 0; j < board.length; j++){
                System.out.printf("|%" + width + "d", board[i][j]);
            }
            System.out.println("|");

        }
        printBorders(board);
        System.out.println();
    }
    /**
     * Prints borders around the numbers
     *
     * @param boardLength the length of random genreted board
     */
    public static void printBorders(int[][] boardLength){
        for(int x = 0; x < boardLength.length; x++){
            System.out.print("+");
            for(int y = 0; y < Math.max((counter / 10), 1); y++)
            {
                System.out.print("-");   
            }
        }
        System.out.println("+");
    }
    /**
     * calls on helper method
     *
     * @param randomly generated board 
     */
    public static void tileCheckerboardRec(int[][] board) {
        tileCheckerboardRec(board, 0, board.length, 0, board.length);
    }
    /**
     * Helper method for tileCheckerboardRec
     *
     * @param board Randomly generated board
     * @param left Start point for Column
     * @param right End point for Column
     * @param top Start point for Row
     * @param bottom End point for Row
     */
    private static void tileCheckerboardRec(int[][] board, int left,
                                                           int right,
                                                           int top,
                                                           int bottom) 
    {
        int midRow = (top + bottom) / 2;
        int midColumn = (right + left) / 2;
        
        if(right - left > 1 )
        {
            //Checks if each quadrant is empty
            boolean quadrant1Empty = isQuadrantEmpty(board, left, midColumn, top, midRow);
            boolean quadrant2Empty = isQuadrantEmpty(board, midColumn, right, top, midRow);
            boolean quadrant3Empty = isQuadrantEmpty(board, left, midColumn, midRow, bottom);
            boolean quadrant4Empty = isQuadrantEmpty(board, midColumn, right, midRow, bottom);
            
            //fills in the innermost space of the quadrant if it is empty
            if(quadrant1Empty)
            {
                board[midRow - 1][midColumn - 1] = counter;
            }
            if(quadrant2Empty)
            {
                board[midRow - 1][midColumn] = counter;    
            }
            if(quadrant3Empty)
            {
                board[midRow][midColumn - 1] = counter;    
            }
            if(quadrant4Empty)
            {
                board[midRow][midColumn] = counter;    
            }
            counter++;
            
            //divide into smaller quadrants and check again
            tileCheckerboardRec(board, left, midColumn, top, midRow);

            tileCheckerboardRec(board, midColumn, right, top, midRow);
            
            tileCheckerboardRec(board, left, midColumn, midRow, bottom);
            
            tileCheckerboardRec(board, midColumn, right, midRow, bottom);

        }
    }
    /**
     * Checks if quadrant is empty
     *
     * @param board Randomly generated board
     * @param left Start point for Column
     * @param right End point for Column
     * @param top Start point for Row
     * @param bottom End point for Row
     * @return Returns true or false depending on whether the the quadrant is empty or not
     */
    
    public static boolean isQuadrantEmpty(int[][] board, int left,
                                                         int right,
                                                         int top,
                                                         int bottom) {
        // Your code goes here.
        boolean isQuadrantEmpty = true;
        for(int i = top; i < bottom; i++){
            for(int j = left; j < right; j++){
                if(board[i][j] != 0){
                    isQuadrantEmpty = false;
                    //counter++;
                }
            }
        }
        return isQuadrantEmpty;
    }
}
