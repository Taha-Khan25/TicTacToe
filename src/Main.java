import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        char player = 'X';
        boolean playerWon = false;
        Scanner scanner = new Scanner(System.in);
        for (char[] chars : board) {
            Arrays.fill(chars, ' ');
        }
        while (!playerWon) {
            printBoard(board);
            System.out.println("Player " + player + " move:");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (x > 2 || y > 2) {
                System.out.println("Invalid input");
            }

            if (ValidMove(board, x, y)) {
                board[x][y] = player;
                playerWon = gameOver(board, player);
                if (!playerWon) {
                    if (player == 'X') {
                        player = '0';
                    } else {
                        player = 'X';
                    }
                } else {
                    System.out.println("Player " + player + " won");
                }
            } else {
                System.out.println("Invalid Move");
            }
        }
    }

    public static void printBoard(char[][] board) {
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar + " | ");
            }
            System.out.println();
        }
    }

    public static boolean gameOver(char[][] board, char player) {
        for (char[] chars : board) {
            if (chars[0] == player && chars[1] == player && chars[2] == player) {
                return true;
            }
        }

        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        return board[0][2] == player && board[1][1] == player && board[2][0] == player;

    }

    public static boolean ValidMove(char[][] board, int x, int y) {

        return board[x][y] == ' ';
    }
}