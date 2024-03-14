class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        var sumFreq = new HashMap<Integer, Integer>();
        sumFreq.put(0, 1);
        int ans = 0;
        int pSum = 0;
        for (int i = 0; i < nums.length;i++) {
            pSum += nums[i];
            ans += sumFreq.getOrDefault(pSum - goal, 0);
            sumFreq.put(pSum, sumFreq.getOrDefault(pSum, 0) + 1);
        }
        return ans;
    }
}
