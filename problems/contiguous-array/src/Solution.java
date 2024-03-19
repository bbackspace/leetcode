class Solution {
    public int findMaxLength(int[] nums) {
        var diffMap = new HashMap<Integer, Integer>();
        int[] sum = new int[2];
        int ans = 0;
        diffMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum[nums[i]]++;
            int d = sum[1] - sum[0];
            if (diffMap.containsKey(d)) {
                ans = Math.max(ans, i - diffMap.get(d));
            } else {
                diffMap.put(d, i);
            }
        }
        return ans;
    }
}
