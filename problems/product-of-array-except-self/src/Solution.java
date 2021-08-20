class Solution {
    public int[] productExceptSelf(int[] nums) {
        // nums _  1  2  3  4 _
        // pref 1  1  2  6 24 _
        // suff _ 24 24 12  4 1
        int[] prefixProd = new int[nums.length + 1];
        int[] suffixProd = new int[nums.length + 1];
        prefixProd[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            prefixProd[i + 1] = prefixProd[i] * nums[i];
        }
        suffixProd[nums.length] = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            suffixProd[i] = suffixProd[i + 1] * nums[i];
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = prefixProd[i] * suffixProd[i + 1];
        }
        return ans;
    }
}

