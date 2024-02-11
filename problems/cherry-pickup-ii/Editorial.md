# Approach
For 1 robot starting at `[0, startPos]`, it would be simple since each row's answer is built from prev row, so DP is applicable.
- `dp[i, j] = max(dp[i - 1, j - 1], dp[i - 1, j], dp[i - 1, j + 1]) + grid[i][j]`
- `dp[0, startPos] = grid[i][j]` (Robot start position)
- `dp[0, j] = -inf` for `j != startPos`

When we have 2 robots at `[0,0]` and `[0, n - 1]`, we need to track both robots' col positions. Hence a 3D DP.
## Recurrence
- `dp[i, j, k] = max over all (a, b) of (dp[i - 1, j + a, k + b]) + grid[i][j] + grid[i][k]` where `a, b in {-1, 0, 1}` for `j != k`
- `dp[i, j, j] = max over all (a, b) of (dp[i - 1, j + a, j + b]) + grid[i][j]` where `a, b in {-1, 0, 1}`
- `dp[0, 0, n - 1] = grid[0][0] + grid[0][n-1]` (Robots start position)
- `dp[0, j, -] = -inf` for `j != 0`
- `dp[0, -, k] = -inf` for `k != n - 1`

Note that the case `dp[i, j, j]` is not applicable for this problem because according to the constraints, `grid[i][j] >= 0`. There is no case where both robots need to overlap and visit the same cell, as an adjacent cell would always be at least 0 cherries and the 2nd robot can be on that cell and pick up more or same (not less) total cherries.

## Final answer
`max over all (j, k) of dp[m - 1, j, k]`

## Complexity
For a grid of size `m * n`,
- Time: $$O(m n^2)$$
- Space: $$O(m n^2)$$

### Space Optimization
You can optimize space complexity by just storing the last 2 layers: `dp[i][][]` and `dp[i - 1][][]` and updating them. You don't need `dp[0..i-2][][]` when processing `i`.

- Time: $$O(m n^2)$$
- Space: $$O(n^2)$$

## Examples
grid
```
3 1 1
2 5 1
1 5 5
2 1 1
```

dp
```
 3  /  /
 5  8  /
 9 13 13
15 14 14
```
