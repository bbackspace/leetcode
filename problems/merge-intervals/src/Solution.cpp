class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }
        sort(intervals.begin(), intervals.end());
        vector<vector<int>> ans;
        int st = intervals[0][0], en = intervals[0][1];
        for (int i = 0; i < intervals.size() - 1; i++) {
            if (en < intervals[i + 1][0]) {
                vector<int> t;
                t.push_back(st);
                t.push_back(en);
                ans.push_back(t);
                st = intervals[i + 1][0];
                en = intervals[i + 1][1];
            } else {
                en = max(en, intervals[i + 1][1]);
            }
        }
        vector<int> t;
        t.push_back(st);
        t.push_back(en);
        ans.push_back(t);
        return ans;
    }
};

