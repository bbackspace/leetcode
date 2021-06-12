class Solution {
    /*
        cmpPrevious(a, i) = a[i - 1] < a[i]
        where i is between [0, n] inclusive,
              a[-1] = a[n] = -inf,
              n = a.length
    */
    private boolean cmpPrevious(int[] nums, int i) {
        if (i <= 0) {
            return true;
        }
        if (i >= nums.length) {
            return false;
        }
        return nums[i - 1] < nums[i];
    }
    private int search(int[] a, int first, int last) {
        if (last <= first) {
            return first;
        } else {
            int mid = (first + last) / 2;
            boolean c1 = cmpPrevious(a, mid);
            boolean c2 = cmpPrevious(a, mid + 1);
            if (c1 && !c2) { //local max
                return mid;
            } else if (c1 && c2) { //right
                return search(a, mid + 1, last);
            } else { //left
                return search(a, first, mid - 1);
            }
        }
    }
    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }
}

