class Solution {
    private long countSubarraysBoundK(List<Integer> nums, int minK, int maxK) {
        long ans = 0;
        int lo = 0, hi = 0;
        int minF = 0, maxF = 0;
        while (hi < nums.size()) {
            if (nums.get(hi) == maxK) {
                maxF++;
            }
            if (nums.get(hi) == minK) {
                minF++;
            }
            hi++;
            while (lo < hi && maxF >= 1 && minF >= 1) {
                if (nums.get(lo) == maxK) {
                    maxF--;
                }
                if (nums.get(lo) == minK) {
                    minF--;
                }
                lo++;
                ans += nums.size() - hi + 1;
            }
        }
        return ans;
    }
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        List<Integer> chunk = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                if (chunk.size() > 0) {
                    ans += countSubarraysBoundK(chunk, minK, maxK);
                    chunk = new ArrayList<>();
                }
            } else {
                chunk.add(nums[i]);
            }
        }
        if (chunk.size() > 0) {
            ans += countSubarraysBoundK(chunk, minK, maxK);
        }
        return ans;
    }
}
