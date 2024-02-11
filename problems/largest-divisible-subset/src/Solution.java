class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int[] subsetLen = new int[nums.length];
        int[] subsetPred = new int[nums.length];
        Arrays.sort(nums);
        int mxIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            int len = 1;
            int pred = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (1 + subsetLen[j] >= len) {
                        len = 1 + subsetLen[j];
                        pred = j;
                    }
                }
            }
            subsetLen[i] = len;
            subsetPred[i] = pred;
            if (len > subsetLen[mxIdx]) {
                mxIdx = i;
            }
        }
        for (int i = mxIdx; i >= 0; i = subsetPred[i]) {
            ans.add(nums[i]);
        }
        return ans;
    }
}
