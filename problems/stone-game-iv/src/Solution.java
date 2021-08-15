class Solution {
    Boolean[] memo = new Boolean[100001];

    public boolean winnerSquareGame(int n) {
        if (memo[n] != null) {
            return memo[n];
        }
        Boolean ans = null;
        if (n == 0) {
            ans = false;
        } else {
            ans = false;
            for (int i = 1; i * i <= n; i++) {
                if (winnerSquareGame(n - i * i) == false) {
                    ans = true;
                    break;
                }
            }
        }
        return memo[n] = ans;
    }
}

