class Solution {
        public static int kmp(String txt, String pat) {
        int matches = 0;
        if (txt == null || pat == null) {
            return 0;
        }
        int m = pat.length(), n = txt.length(), i = 0, j = 0;
        if (m > n) return 0;

        int[] arr = kmpHelper(pat, m);

        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == m) {
                matches++;
                j = arr[j - 1];
            } else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = arr[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }

        return matches;
    }

    private static int[] kmpHelper(String pat, int m) {
        int[] arr = new int[m];
        for (int i = 1, len = 0; i < m; ) {
            if (pat.charAt(i) == pat.charAt(len)) {
                arr[i++] = ++len;
            } else {
                if (len > 0) len = arr[len - 1];
                else i++;
            }
        }
        return arr;
    }
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;
        StringBuilder s = new StringBuilder();
        StringBuilder p = new StringBuilder();
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) {
                s.append('a');
            } else if (nums[i - 1] == nums[i]) {
                s.append('b');
            } else {
                s.append('c');
            }
        }
        for (int i = 0; i < m; i++) {
            if (pattern[i] == 1) {
                p.append('a');
            } else if (pattern[i] == 0) {
                p.append('b');
            } else {
                p.append('c');
            }
        }
        return kmp(s.toString(), p.toString());
    }
}
