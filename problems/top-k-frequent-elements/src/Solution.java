class Solution {
    private int[] slow(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int a: nums) {
            int count = cnt.getOrDefault(a, 0);
            cnt.put(a, count + 1);
        }
        return cnt.entrySet()
            .stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
            .limit(k)
            .mapToInt(e -> e.getKey())
            .toArray();
    }

    private int[] fast(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int a: nums) {
            int count = cnt.getOrDefault(a, 0);
            cnt.put(a, count + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        cnt.entrySet()
            .forEach(e -> {
                maxHeap.add(e);
            });
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(maxHeap.remove().getKey());
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
    public int[] topKFrequent(int[] nums, int k) {
        boolean runFast = true;
        if (runFast) {
            return fast(nums, k);
        }
        return slow(nums, k);
    }
}

