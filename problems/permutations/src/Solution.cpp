class Solution {
    void perm(vector<int> &nums, vector<vector<int>> &ans, int d) {
        if (d == nums.size()) {
            ans.push_back(nums);
            return;
        }
        for (int i = d; i < nums.size(); i++) {
            swap(nums[d], nums[i]);
            perm(nums, ans, d + 1);
            swap(nums[d], nums[i]);
        }
    }
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> ans;
        perm(nums, ans, 0);
        return ans;
    }
};

