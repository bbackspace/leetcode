class Solution {
    private boolean isOverlap(int[] iA, int[] iB) {
        if (iA[1] < iB[0] || iB[1] < iA[0]) {
            return false;
        }
        return true;
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        var list = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; i++) {
            if (!isOverlap(intervals[i], newInterval)) {
                list.add(intervals[i]);
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        list.add(newInterval);
        return list.stream().sorted((int[] a, int[] b) -> a[0] - b[0]).toArray(int[][]::new);
    }
}
