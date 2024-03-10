class Solution {
    static class Rect {
        int x1;
        int y1;
        int x2;
        int y2;
        Rect(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        long area() {
            return (y2 - y1) * (x2 - x1);
        }
        long overlapArea(Rect b) {
            return Math.max(0, overlapX(b)) * Math.max(0, overlapY(b));
        }
        private int overlapX(Rect b) {
            return Math.min(x2, b.x2) - Math.max(x1, b.x1);
        }

        private int overlapY(Rect b) {
            return Math.min(y2, b.y2) - Math.max(y1, b.y1);
        }
    }
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        Rect a = new Rect(ax1, ay1, ax2, ay2);
        Rect b = new Rect(bx1, by1, bx2, by2);
        return (int) (a.area() + b.area() - a.overlapArea(b));
    }
}
