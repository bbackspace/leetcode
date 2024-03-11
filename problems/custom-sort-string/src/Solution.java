class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, 1 + counts.getOrDefault(c, 0));
        }
        StringBuilder ans = new StringBuilder();
        for (char c : order.toCharArray()) {
            for (int i = 0; i < counts.getOrDefault(c, 0); i++) {
                ans.append(c);
            }
            counts.remove(c);
        }
        for (Map.Entry<Character, Integer> count : counts.entrySet()) {
            for (int i = 0; i < count.getValue(); i++) {
                ans.append(count.getKey());
            }
        }
        return ans.toString();
    }
}
