class Solution {
    public void sortColors(int[] nums) {
        int L = 0;
        int R = nums.length;
        for (int i = 0; i < R; ) {
            if (nums[i] == 0) {
                nums[i] = nums[L];
                nums[L] = 0;
                L++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                R--;
                nums[i] = nums[R];
                nums[R] = 2;
            }
        }
    }
}

