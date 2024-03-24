class Solution {
    public int findDuplicate(int[] nums) {
        int N = nums.length - 1;
        int lo = 1, hi = N;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int numsLowerMid = 0;
            for (int k : nums) {
                if (k <= mid) {
                    numsLowerMid++;
                }
            }
            if (numsLowerMid > mid) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
