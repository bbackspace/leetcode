class Solution {
    public int countSubstrings(String s) {
        char[] str = s.toCharArray();
        int len = s.length();
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            //single letter str[i] = palindrome
            cnt++;

            // palindromes centered around str[i] (odd length)
            for (int j = 1; i - j >= 0 && i + j < len; j++) {
                if (str[i - j] != str[i + j]) {
                    break;
                }
                cnt++;
            }
            
            // palindromes centered around space between str[i] and str[i + 1] (even length)
            for (int j = 1; i - j + 1 >= 0 && i + j < len; j++) {
                if (str[i - j + 1] != str[i + j]) {
                    break;
                }
                cnt++;
            }
        }
        return cnt;
    }
}
