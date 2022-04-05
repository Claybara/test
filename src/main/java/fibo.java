public class fibo {

    public static int fibo(int n) {
        if (n <= 1) {
            return n;
        }
        return fibo(n - 2) + fibo(n - 1);
    }

    public static int fiboDP(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    public static int fiboMemo(int n, int[] memo) {

        if (n <= 1) {
            return n;
        }

        if (memo[n - 1] == 0) {
            memo[n - 1] = fiboMemo(n - 1, memo) + fiboMemo(n - 2, memo);
        } else {
            return memo[n - 1];
        }

        return memo[n - 1];
    }

    public static void main(String args[]) {
        int n = 10;
        System.out.println(fibo(n));
        System.out.println(fiboDP(n));
        int[] memo = new int[n];
        System.out.println(fiboMemo(n, memo));
    }
}
