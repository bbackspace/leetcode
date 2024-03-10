class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        long dx = (long)sx - fx;
        long dy = (long)sy - fy;
        if (dx < 0) {
            dx = -dx;
        }
        if (dy < 0) {
            dy = -dy;
        }
        if (dx == 0 && dy == 0) {
            return t != 1;
        }
        return t >= Math.max(dx, dy);
    }
}
