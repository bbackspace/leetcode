class Solution {
    private void rec(Set<List<Integer>> set, List<Integer> partial, List<Integer> nums) {
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
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        rec(ans, new ArrayList<>(), Arrays.stream(nums).boxed().collect(Collectors.toList()));
        return ans.stream().collect(Collectors.toList());
    }
}

