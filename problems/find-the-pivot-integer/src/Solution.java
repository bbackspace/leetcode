class Solution {
    public int pivotInteger(int n) {
        int sumn = n * (n + 1) / 2;
        int x = (int) Math.sqrt(sumn);
        if (x * x == sumn) {
            return x;
        } else {
            return -1;
        }
    }
}
