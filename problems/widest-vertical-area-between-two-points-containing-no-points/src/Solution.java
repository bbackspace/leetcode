class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < points.length; i++) {
            set.add(points[i][0]);
        }
        int prev = -1;
        int maxW = 0;
        for (Integer x : set) {
            if (prev != -1) {
                if (maxW < x - prev) {
                    maxW = x - prev;
                }
            }
            prev = x;
        }
        return maxW;
    }
}

