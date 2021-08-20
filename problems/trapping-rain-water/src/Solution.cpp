class Solution {
public:
    int trap(vector<int>& height) {
        int N = height.size();
        if (N <= 1) {
            return 0;
        }
        vector<int> maxL(N, 0);
        vector<int> maxR(N, 0);
        maxL[0] = height[0];
        maxR[N - 1] = height[N - 1];
        for (int i = 1; i < N; i++) {
            maxL[i] = max(maxL[i - 1], height[i]);
            maxR[N - 1 - i] = max(maxR[N - i], height[N - 1 - i]);
        }
        int vol = 0;
        for (int i = 1; i < N - 1; i++) {
            vol += max(0, (min(maxL[i - 1], maxR[i + 1])) - height[i]);
        }
        return vol;
    }
};

