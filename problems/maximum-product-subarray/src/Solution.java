class Solution {
    public int maxProduct(int[] nums) {
        return const_space(nums);
    }
    
    private int linear_space(int[] nums) {
        int[] dpp = new int[nums.length]; //dpp[i] = largest product of all the subarrays of nums ending at i
        int[] dpn = new int[nums.length]; //dpn[i] = smallest product of all the subarrays of nums ending at i
        dpp[0] = nums[0];
        dpn[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpp[i] = Math.max(Math.max(dpp[i-1] * nums[i], nums[i]), dpn[i-1] * nums[i]);
            dpn[i] = Math.min(Math.min(dpp[i-1] * nums[i], nums[i]), dpn[i-1] * nums[i]);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < dpp.length; i++) {
            ans = Math.max(ans, dpp[i]);
        }
        return ans;
    }

    private int const_space(int[] nums) {
        int dpp = nums[0]; //dpp = largest product of all the subarrays of nums encountered yet.
        int dpn = nums[0]; //dpn = smallest product of all the subarrays of nums encountered yet.
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int old_dpp = dpp;
            dpp = Math.max(Math.max(dpp * nums[i], nums[i]), dpn * nums[i]);
            dpn = Math.min(Math.min(old_dpp * nums[i], nums[i]), dpn * nums[i]);
            ans = Math.max(ans, dpp);
        }
        return ans;
    }
}

