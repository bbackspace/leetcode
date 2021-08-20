class Solution {
    private static class Case {
        private Map<Integer, Integer> mem;
        private int[] c;
        private Case(int[] coins) {
            mem = new HashMap<>();
            c = coins;
        }
        
        private int f(int x) {
            if (mem.get(x) != null) {
                return mem.get(x);
            }
            int ans = -1;
            if (x == 0) {
                ans = 0;
            } else if (x > 0) {
                for (int i = 0; i < c.length; i++) {
                    int k = f(x - c[i]);
                    if (k > -1) {
                        if (ans == -1)
                            ans = k + 1;
                        else
                            ans = Math.min(ans, k + 1);
                    }
                }
            }
            mem.put(x, ans);
            return ans;
        }
    }
    public int coinChange(int[] coins, int amount) {
        return new Case(coins).f(amount);
    }
}

