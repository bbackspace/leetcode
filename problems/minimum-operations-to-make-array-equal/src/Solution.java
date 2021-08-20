class Solution {
    public int minOperations(int n) {
        // sum of AP from a=n-1, d=2, n=floor(n/2)
        int f = n/2;
        return f * (n - f);
    }
}

