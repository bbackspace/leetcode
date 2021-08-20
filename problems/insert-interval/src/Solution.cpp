class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        vector<vector<int>> ans;
        int st = newInterval[0], en = newInterval[1];
        for (auto &s : intervals) {
            if (newInterval[0] > s[1] || newInterval[1] < s[0]) {
                ans.push_back(s);
            } else {
                st = min(st, s[0]);
                en = max(en, s[1]);
            }
        }
        vector<int> t;
        t.push_back(st);
        t.push_back(en);
        ans.push_back(t);
        sort(ans.begin(), ans.end());
        return ans;
    }
};

