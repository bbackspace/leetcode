class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int lo = 0, hi = 0, ans = 0;
        var freq = new HashMap<Integer, Integer>();
        while (hi < nums.length) {
            int key = nums[hi++];
            freq.put(key, freq.getOrDefault(key, 0) + 1);
            while (lo < hi && freq.get(key) > k) {
                int key2 = nums[lo++];
                freq.put(key2, freq.get(key2) - 1);
            }
            ans = Math.max(ans, hi - lo);
        }
        return ans;
    }
}
