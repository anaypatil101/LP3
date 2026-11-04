import java.util.Arrays;
import java.util.Scanner;

public class Knapsack {

    static int knapsack(int ind, int[] wt, int[] val, int W, int[][] dp) {

        if(ind == 0) {
            if(wt[ind] <= W)
                return val[ind];
            else 
                return 0;
        }

        if (dp[ind][W] != -1)
            return dp[ind][W];

        int notTake = 0 + knapsack(ind - 1, wt, val, W, dp);
        int take = Integer.MIN_VALUE;

        if(wt[ind] <= W) {
            take = val[ind] + knapsack(ind-1, wt, val, W - wt[ind], dp);
        }

        return dp[ind][W] = Math.max(take, notTake);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // number of items
        int W = sc.nextInt();   // knapsack capacity

        int[] wt = new int[n];
        int[] val = new int[n];

        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
            val[i] = sc.nextInt();
        }

        // dp[i][w] = best profit using first i items with capacity w
        int[][] dp = new int[n + 1][W + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        System.out.println("Maximum Profit = " + knapsack(n-1,wt, val, W, dp));

        sc.close();
    }
}