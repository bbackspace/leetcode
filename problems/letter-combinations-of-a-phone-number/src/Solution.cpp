class Solution {
    const vector<string> keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    string s;
    vector<string> ans;
    void comb(string &dig, int d) {
        if (dig.length() == 0) {
            return;
        }
        if (d == dig.length()) {
            ans.push_back(s);
            return;
        }
        for (auto &k : keypad[dig[d] - '0']) {
            s.push_back(k);
            comb(dig, d + 1);
            s.pop_back();
        }
    }
public:
    vector<string> letterCombinations(string digits) {
        ans = vector<string>();
        s = "";
        comb(digits, 0);
        return ans;
    }
};

