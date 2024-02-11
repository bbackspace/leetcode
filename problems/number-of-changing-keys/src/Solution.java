class Solution {
    public int countKeyChanges(String s) {
        String l = s.toLowerCase();
        int cnt = 0;
        for (int i = 1; i < l.length(); i++) {
            if (l.charAt(i) != l.charAt(i - 1)) {
                cnt++;
            }
        }
        return cnt;
    }
}
