class Solution {
    private void rec(List<List<Integer>> set, List<Integer> partial, List<Integer> nums) {
        if (0 == nums.size()) {
            set.add(partial.stream().collect(Collectors.toList()));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            Integer e = nums.remove(i);
            partial.add(e);
            rec(set, partial, nums);
            partial.remove(partial.size() - 1);
            nums.add(i, e);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        rec(ans, new ArrayList<>(), Arrays.stream(nums).boxed().collect(Collectors.toList()));
        return ans;
    }
}

