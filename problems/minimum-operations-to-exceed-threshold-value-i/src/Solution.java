class Solution {
    public int minOperations(int[] nums, int k) {
        int ans = 0;
        for (int n : nums) {
            if (n < k) {
                ans++;
            }
        }
        return ans;
    }
}
