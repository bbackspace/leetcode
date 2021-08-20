class Solution {
    private void rec(Set<List<Integer>> set, Deque<Integer> partial, int[] nums, int idx) {
        if (idx == nums.length) {
            set.add(new ArrayList<>(partial));
            return;
        }
        //Without i'th item
        rec(set, partial, nums, idx + 1);
        partial.addLast(nums[idx]);
        rec(set, partial, nums, idx + 1);
        partial.removeLast();
    }
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> ans = new HashSet();
        rec(ans, new ArrayDeque(), nums, 0);
        return ans.stream().collect(Collectors.toList());
    }
}

