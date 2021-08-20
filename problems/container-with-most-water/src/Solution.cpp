class Solution {
public:
    int maxArea(vector<int>& height) {
        int ans = 0;
        int L = 0, R = height.size() - 1;
        while (L < R) {
            if (height[L] < height[R]) {
                ans = max(ans, height[L] * (R - L));
                L++;
            } else {
                ans = max(ans, height[R] * (R - L));
                R--;
            }
        }
        return ans;
    }
};

