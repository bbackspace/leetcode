class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int n : nums) {
            pq.add((long) n);
        }
        int ans = 0;
        while (pq.size() >= 2 && pq.peek() < (long) k) {
            long l = pq.poll();
            long r = pq.poll();
            pq.offer(l * 2 + r);
            ans++;
        }
        return ans;
    }
}
