class Solution {
    private boolean match(int[] nums, int[] pattern, int i) {
        int n = nums.length;
        int m = pattern.length;
        for (int k = 0; k < m && i + k + 1 < n; k++) {
            if (pattern[k] == 1) {
                if (nums[i + k + 1] <= nums[i + k]) {
                    return false;
                }
            } else if (pattern[k] == 0) {
                if (nums[i + k + 1] != nums[i + k]) {
                    return false;
                }
            } else {
                if (nums[i + k + 1] >= nums[i + k]) {
                    return false;
                }
            }
        }
        return true;
    }
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;
        int cnt = 0;
        for (int i = 0; i + m < n; i++) {
            if (match(nums, pattern, i)) {
                cnt++;
            }
        }
        return cnt;
    }
}
