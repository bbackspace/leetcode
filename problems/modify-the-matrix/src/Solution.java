class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int [][] answer = Arrays.stream(matrix)
            .map(int[]::clone)
            .toArray(int[][]::new);
        int m = matrix.length;
        int n = matrix[0].length;
        for (int j = 0; j < n; j++) {
            int max = 0;
            for (int i = 0; i < m; i++) {
                max = Math.max(max, answer[i][j]);
            }
            for (int i = 0; i < m; i++) {
                if (answer[i][j] == -1) {
                    answer[i][j] = max;
                }
            }
        }
        return answer;
    }
}
