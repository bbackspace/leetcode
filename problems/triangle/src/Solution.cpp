class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        vector<vector<int>> dp(triangle.size(), vector<int>(triangle.size(), 0));
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.size(); i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            for (int j = 1; j < triangle[i].size(); j++) {
                if (j == triangle[i].size() - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
                }
            }
        }

        int ans = dp[triangle.size() - 1][0];
        for (int i = 1; i < triangle.size(); i++) {
            ans = min(ans, dp[triangle.size() - 1][i]);
        }
        return ans;
    }
    void print(vector<vector<int>> v) {
        cout << "[";
        print(v[0]);
        for (int i = 1; i < v.size(); i++) {
            cout << ",\n";
            print(v[i]);
        }
        cout << "]";
    }
    void print(vector<int> v) {
        cout << "[";
        cout << (v[0]);
        for (int i = 1; i < v.size(); i++) {
            cout << ",";
            cout << (v[i]);
        }
        cout << "]";
    }
};

