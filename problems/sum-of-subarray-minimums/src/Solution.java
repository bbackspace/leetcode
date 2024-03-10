class Solution {
    private static long MOD = 1000000007L;
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        var stack = new Stack<Integer>();
        // populate prevSmaller - keep monotonically strictly increasing (discarding equals)
        int[] prevSmaller = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                prevSmaller[i] = -1;
            } else {
                prevSmaller[i] = stack.peek();
            }
            stack.push(i);
        }

        // populate nextSmallerOrEqual - keep monotonically increasing (keep equals)
        stack.clear();
        int[] nextSmallerOrEqual = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nextSmallerOrEqual[i] = n;
            } else {
                nextSmallerOrEqual[i] = stack.peek();
            }
            stack.push(i);
        }

        long ans = 0L;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long) arr[i] * (i - prevSmaller[i]) * (nextSmallerOrEqual[i] - i)) % MOD;
        }
        return (int) ans;
    }
}
