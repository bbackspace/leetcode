class Solution {
    private static final Map<Integer, String> K;
    
    static {
        K = new HashMap<>();
        K.put(2, "abc");
        K.put(3, "def");
        K.put(4, "ghi");
        K.put(5, "jkl");
        K.put(6, "mno");
        K.put(7, "pqrs");
        K.put(8, "tuv");
        K.put(9, "wxyz");
    }

    private List<String> recurse(List<Integer> d) {
        if (d.size() == 0) {
            return Arrays.asList("");
        }
        List<String> rest = recurse(d.subList(1, d.size()));
        List<String> ans = new ArrayList<>();
        for (char c : K.get(d.get(0)).toCharArray()) {
            for (String x: rest) {
                ans.add(c + x);
            }
        }
        return ans;
    }

    public List<String> letterCombinations(final String digits) {
        if (digits.equals("")) {
            return new ArrayList<>();
        }
        char[] digitsCharArray = digits.toCharArray();
        List<Integer> digitsIntArray = new ArrayList<>();
        for(int i = 0; i < digitsCharArray.length; i++) {
            digitsIntArray.add(Integer.parseInt(String.valueOf(digitsCharArray[i])));
        }
        return recurse(digitsIntArray);
    }
    
    
}

