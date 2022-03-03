import java.util.Scanner;
import java.util.Random;
/**
 * See the project description for details about what is expected
 * for the methods outlind below.
 *
 * @author (your name)
 * @version (a version number or a date)
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
    
    public static int[][] getRandomBoard(int exp) {
        // Your code goes here.
        int[][] board = new int[8][8];
        Random rand = new Random();
        int firstTileRow = 5;
        int firstTileColumn = 6;
        board[5][6] = counter;
        counter++;
        return board;
        // Don't forget to increment counter in here.
    }

    public static void printBoard(int[][] board) {
        for(int i = 0; i < 8; i++)
        {
            System.out.println("+--+--+--+--+--+--+--+--");
            for(int j = 0; j < 8; j++)
            {
                System.out.printf("|%2d|", board[i][j]);
            }
            System.out.println();
        }
    }
    
    public static void tileCheckerboardRec(int[][] board) {
        // Your code goes here.
        tileCheckerboardRec(board, 0, board.length, 0, board.length);
    }

    private static void tileCheckerboardRec(int[][] board, int left,
                                                           int right,
                                                           int top,
                                                           int bottom) {
        // Your code goes here.
        boolean quadrant1Empty = isQuadrantEmpty(board, left, (right / 2), top, (bottom / 2));
        boolean quadrant2Empty = isQuadrantEmpty(board, (right / 2) + 1, right, top, (bottom / 2));
        boolean quadrant3Empty = isQuadrantEmpty(board, left, (right / 2), (bottom / 2), bottom);
        boolean quadrant4Empty = isQuadrantEmpty(board, (right / 2), right, (bottom / 2), bottom);
        if(right > 1 && bottom > 1)
        {
            if(quadrant1Empty)
            {
                board[(bottom / 2) - 1][(right / 2) - 1] = counter;
                //counter++;
                //tileCheckerboardRec(board, left, right / 2, top, bottom / 2);
            }
            if(quadrant2Empty)
            {
                board[(bottom / 2) - 1][(right / 2)] = counter;    
                //counter++;
                //tileCheckerboardRec(board, (right / 2), right, top, bottom / 2);
            }
            if(quadrant3Empty)
            {
                board[(bottom / 2)][(right / 2) - 1] = counter;    
                //counter++;
                //tileCheckerboardRec(board, left, right / 2, bottom / 2, bottom);
            }
            if(quadrant4Empty)
            {
                board[(bottom / 2)][(right / 2)] = counter;    
                //counter++;
                //tileCheckerboardRec(board, right / 2, right, bottom / 2, bottom);
            }
            counter++;
            if(quadrant1Empty)
            {
                tileCheckerboardRec(board, left, right / 2, top, bottom / 2);
            }
            else if(quadrant2Empty)
            {
                tileCheckerboardRec(board, (right / 2), right, top, bottom / 2);
            }
            else if(quadrant3Empty)
            {
                tileCheckerboardRec(board, left, right / 2, bottom / 2, bottom);
            }
            else if(quadrant4Empty)
            {
                tileCheckerboardRec(board, right / 2, right, bottom / 2, bottom);
            }
        }
        
    }
    /*
    public static boolean isQuadrantEmpty(int[][] board, int left,
                                                         int right,
                                                         int top,
                                                         int bottom) {
        int colSearched = left;
        int rowSearched = top;
        if(board[rowSearched][colSearched] > 0)
        {
            System.out.println("\n");
            printBoard(board);
            return false;
        }
        else if(colSearched + 1 < right)
        {
            return isQuadrantEmpty(board, colSearched + 1, right, top, bottom);
        }
        else if(rowSearched + 1 < bottom)
        {
            return isQuadrantEmpty(board, left, right, rowSearched + 1, bottom);   
        }
        else
        {
            System.out.println("\n");
            printBoard(board);
            return true;   
        }
    }

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
