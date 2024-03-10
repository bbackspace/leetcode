class Solution {
    public int minimumLength(String s) {
        char[] ch = s.toCharArray();
        int l = 0;
        int r = ch.length - 1;
        while (l < r && ch[l] == ch[r]) {
            int c = ch[l];
            if (c != ch[r]) {
                break;
            }
            while (l <= r && ch[l] == c) {
                l++;
            }
            while (l <= r && ch[r] == c) {
                r--;
            }
        }
        return r - l + 1;
    }
}
