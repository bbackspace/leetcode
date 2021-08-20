class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] hash = new int[2051];
        for (int i = 0; i < logs.length; i++) {
            for (int y = logs[i][0]; y < logs[i][1]; y++) {
                hash[y]++;
            }
        }
        int max = 0;
        for (int y = 1950; y <= 2050; y++) {
            max = Math.max(max, hash[y]);
        }
        for (int y = 1950; y <= 2050; y++) {
            if (hash[y] == max) {
                return y;
            }
        }
        return 1950;
    }
}

