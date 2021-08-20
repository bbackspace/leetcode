class Solution {
    public String largestNumber(int[] nums) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            ans.add(String.valueOf(nums[i]));
        }
        Collections.sort(ans, (a, b) -> {
            return (b + a).compareTo(a + b);
        });
        if (ans.size() > 0 && ans.get(0).equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : ans) {
            sb.append(s);
        }
        return sb.toString();
    }
}

