import java.util.Scanner;

public class main {
    public static void main(String[] args) {
       char[][] board = new char[3][3];

       for(int row =0;row<board.length;row++){
        for(int col=0;col<board.length;col++){
            board[row][col]=' ';
        }
       }

       char player = 'X';
       boolean gameOver = false;
       Scanner in = new Scanner(System.in);

       while(!gameOver){
        printBoard(board);
        System.out.println("Player "+player+" Enter: ");
        int row = in.nextInt();
        int col = in.nextInt(); 
        System.out.println();

        if(board[row][col]==' '){
            board[row][col]=player; 
            gameOver = haveWon(board, player);
            if(gameOver){
                System.out.println("Player "+player+" has Won. ");
            }
            else{
                if(player=='X'){
                    player = 'O';
                }
                else{
                    player = 'X';
                }
                
            }
        }
        else{
            System.out.println("Invalid move. Try again!");
        }
       }
       printBoard(board);
    }

    public static boolean  haveWon(char[][] board, char player){
        // for rows
        for(int row =0;row<board.length;row++)
        {
            if(board[row][0]==player && board[row][1]==player && board[row][2]==player){
                return true;
            }
        }

        //for col
        for(int col =0;col<board.length;col++)
        {
            if(board[0][col]==player && board[1][col]==player && board[2][col]==player){
                return true;
            }
        }

        //for diagonal
        if(board[0][0]==player && board[1][1] == player && board[2][2]==player){
            return true;
        }
        if(board[0][2]==player && board[1][1] == player && board[2][0]==player){
            return true;
        }
        return false;
    }

    public static void printBoard(char[][] board){
        for(int row =0;row<board.length;row++)
        {
            for(int col=0;col<board.length;col++)
            {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        } 
         
    }
    
}
