import java.util.Scanner;

public class NQueens {

    // Check whether a queen can be placed at (row, col)
    static boolean isSafe(int[][] board, int row, int col, int n) {
        // Check column above
        int i = row - 1;
        while (i >= 0) {
            if (board[i][col] == 1)
                return false;
            i--;
        }

        // Check left diagonal (up and to the left)
        int r = row - 1;
        int c = col - 1;
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 1)
                return false;
            r--;
            c--;
        }

        // Check right diagonal (up and to the right)
        r = row - 1;
        c = col + 1;
        while (r >= 0 && c < n) {
            if (board[r][c] == 1)
                return false;
            r--;
            c++;
        }

        return true;
    }

    // Place queens row by row
    static void solve(int[][] board, int row, int n) {

        // All queens placed: print this solution
        if (row == n) {
            System.out.println("Solution:");

            for (int[] r : board) {
                for (int x : r)
                    System.out.print((x == 1 ? "Q" : "_") + " ");
                System.out.println();
            }

            System.out.println();
            return;
        }

        // Try every column in this row
        for (int col = 0; col < n; col++) {

            if (isSafe(board, row, col, n)) {

                board[row][col] = 1;       // place queen

                solve(board, row + 1, n);  // go to next row

                board[row][col] = 0;       // backtrack
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // Java zero-initializes, so the board starts empty
        int[][] board = new int[n][n];

        solve(board, 0, n);

        sc.close();
    }
}