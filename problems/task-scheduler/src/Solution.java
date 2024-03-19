class Solution {

    public int leastInterval(char[] tasks, int n) {
        var freq = new HashMap<Character, Integer>();
        for (char c: tasks) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int maxFr = 0, cntMaxFr = 0;
        for (var e: freq.entrySet()) {
            if (e.getValue() > maxFr) {
                maxFr = e.getValue();
                cntMaxFr = 1;
            } else if (e.getValue() == maxFr) {
                cntMaxFr++;
            }
        }
        return Math.max((maxFr - 1) * (n + 1) + cntMaxFr, tasks.length);
    }
}
