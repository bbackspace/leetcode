class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }
    
    private int rob(int[] nums, int startIdx, int endIdx) {
        int rb = nums[startIdx];
        int nrb = 0;
        for (int i = startIdx + 1; i < endIdx; i++) {
            int robthisone = nrb + nums[i];
            int notrobthisone = Math.max(rb, nrb);
            rb = robthisone;
            nrb = notrobthisone;
        }
        return Math.max(rb, nrb);
    }
}

