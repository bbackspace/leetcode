class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int l = 0;
        int r = tokens.length - 1;
        int score = 0;
        while (l <= r) {
            if (power >= tokens[l]) {
                power -= tokens[l++];
                score++;
            } else if (score >= 1 && l < r){
                power += tokens[r--];
                score--;
            } else {
                return score;
            }
        }
        return score;
    }
}
