class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        var freq = new HashMap<Integer, Integer>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        for (var entry: freq.entrySet()) {
            if (entry.getValue() > 2) {
                return false;
            }
        }
        return true;
    }
}
