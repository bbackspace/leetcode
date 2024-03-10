class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        var h = new HashSet<Integer>();
        for (int num: nums1) {
            h.add(num);
        }
        var ans = new ArrayList<Integer>();
        for (int num: nums2) {
            if (h.contains(num)) {
                ans.add(num);
                h.remove(num);
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
