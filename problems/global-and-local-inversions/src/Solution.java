class Solution {
    public boolean isIdealPermutation(int[] A) {
        if (A.length < 2) {
            return true;
        }
        int localInversions = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] > A[i]) {
                localInversions++;
            }
        }
        int globalInversions = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    globalInversions++;
                }
                if (globalInversions > localInversions) {
                    return false;
                }
            }
        }
        return localInversions == globalInversions;
    }
}

