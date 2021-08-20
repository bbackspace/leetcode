class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        // indices for the 2 pointers
        int p1 = 0, p2 = 0;
        // partial sums of each section between junction points. A junction point is either the start, end or positions of same value.
        long s1 = 0L, s2 = 0L;
        
        long totalSum = 0L;
        final long mod = 1000000007L;

        while (p1 < nums1.length && p2 < nums2.length) {
            switch(Integer.compare(nums1[p1], nums2[p2])) {
                case 0: // junction point reached
                    totalSum += Math.max(s1, s2) + nums1[p1];
                    s1 = 0;
                    s2 = 0;
                    p1++;
                    p2++;
                    break;
                case -1: // p1 has the smaller number, move it forward
                    s1 += nums1[p1];
                    p1++;
                    break;
                case 1: // p2 has the smaller number, move it forward
                    s2 += nums2[p2];
                    p2++;
                    break;
            }
        }
        
        // collect sums between the last junction point and the end of the arrays.
        for(; p1 < nums1.length; p1++) {
            s1 += nums1[p1];
        }
        for(; p2 < nums2.length; p2++) {
            s2 += nums2[p2];
        }

        return (int) ((totalSum + Math.max(s1, s2)) % mod);
    }
}

