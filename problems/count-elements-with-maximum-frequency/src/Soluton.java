class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int mxF = 0;
        for (int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            mxF = Math.max(mxF, freq.get(num));
        }
        int ans = 0;
        for (var e: freq.entrySet()) {
            if (e.getValue() == mxF) {
                ans += mxF;
            }
        }
        return ans;
    }
}
