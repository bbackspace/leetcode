class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
        int n = words.length;
        int pairs = 0;
        Map<Character, Integer> freq = new HashMap<>();
        List<Integer> rp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rp.add(words[i].length() / 2);
            for (char c: words[i].toCharArray()) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
        }
        for (Integer v: freq.values()) {
            pairs += v / 2;
        }
        Collections.sort(rp);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            pairs -= rp.get(i);
            if (pairs < 0) {
                return cnt;
            }
            cnt++;
        }
        return cnt;
    }
}
