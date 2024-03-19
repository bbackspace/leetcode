class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (int[] pA, int[] pB) -> Integer.compare(pA[0], pB[0]));
        int ans = 1;
        int arrow = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (arrow < points[i][0]) {
                ans++;
                arrow = points[i][1];
            } else {
                arrow = Math.min(arrow, points[i][1]);
            }
        }
        return ans;
    }
}
