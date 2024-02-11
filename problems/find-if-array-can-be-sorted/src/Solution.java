class Solution {
    private int numSetBits(int x) {
        int setbits = 0;
        while (x > 0) {
            setbits++;
            x = x & (x - 1);
        }
        return setbits;
    }
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int[] setBits = new int[n];
        for (int i = 0; i < n; i++) {
            setBits[i] = numSetBits(nums[i]);
        }
        int[] maxSec = new int[n];
        int[] minSec = new int[n];
        maxSec[0] = nums[0];
        minSec[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            if (setBits[i] == setBits[i - 1]) {
                maxSec[i] = Math.max(maxSec[i - 1], nums[i]);
            } else {
                maxSec[i] = nums[i];
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (setBits[i] == setBits[i + 1]) {
                minSec[i] = Math.min(minSec[i + 1], nums[i]);
            } else {
                minSec[i] = nums[i];
            }
        }
        for (int i = 1; i < n; i++) {
            if (setBits[i - 1] != setBits[i] && maxSec[i - 1] > minSec[i]) {
                return false;
            }
        }
        return true;
    }
}
