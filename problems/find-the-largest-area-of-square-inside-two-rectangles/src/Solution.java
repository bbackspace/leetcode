class Solution {
    static class Rect {
        int x1;
        int y1;
        int x2;
        int y2;
        Rect(int[] bottomLeft, int[] topRight) {
            this.x1 = bottomLeft[0];
            this.y1 = bottomLeft[1];
            this.x2 = topRight[0];
            this.y2 = topRight[1];
        }

        int overlapSqSide(Rect b) {
            return Math.max(0, Math.min(overlapX(b), overlapY(b)));
        }
        private int overlapX(Rect b) {
            return Math.min(x2, b.x2) - Math.max(x1, b.x1);
        }

        private int overlapY(Rect b) {
            return Math.min(y2, b.y2) - Math.max(y1, b.y1);
        }
    }
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int max = 0;
        int n = bottomLeft.length;
        Rect[] rects = new Rect[n];
        for (int i = 0; i < n; i++) {
            rects[i] = new Rect(bottomLeft[i], topRight[i]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                max = Math.max(max, rects[i].overlapSqSide(rects[j]));
            }
        }
        return (long) max * max;
    }
}
