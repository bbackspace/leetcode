class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalApples = 0;
        for (int apples: apple) {
            totalApples += apples;
        }
        Arrays.sort(capacity);
        int ans = 0;
        for (int i = capacity.length - 1; i >= 0; i--) {
            totalApples -= capacity[i];
            ans++;
            if (totalApples <= 0) {
                return ans;
            }
        }
        return ans;
    }
}
