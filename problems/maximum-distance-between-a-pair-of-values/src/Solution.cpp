using namespace std;
class Solution {
public:
    int maxDistance(vector<int>& nums1, vector<int>& nums2) {
        int maxD = 0;
        for (auto i = 0; i < nums1.size(); i++) {
            int s = nums1[i];
            int j = upper_bound(nums2.begin(), nums2.end(), s, [](int a, int b) { return a > b; }) - nums2.begin() - 1;
            maxD = max(maxD, j - i);
        }
        return maxD;
    }
};

