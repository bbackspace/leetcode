class Solution {
    public int rob(int[] nums) {
        int rb = nums[0];
        int nrb = 0;
        for (int i = 1; i < nums.length; i++) {
            int robthisone = nrb + nums[i];
            int notrobthisone = Math.max(rb, nrb);
            rb = robthisone;
            nrb = notrobthisone;
        }
        return Math.max(rb, nrb);
    }
}

