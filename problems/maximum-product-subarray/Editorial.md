# Approach
Let,
`dp_max[i]` = largest product of all the subarrays of nums ending at i
`dp_min[i]` = smallest product of all the subarrays of nums ending at i

At every `nums[i]`, we can either choose to start a new subarray, or include the previous subarray and extend it.
1. Case 1: start a new subarray: `dp_max[i] = dp_min[i] = nums[i]`
2. Case 2: Include the previous subarray and extend it.
   * Case 2a: the resultant product is larger than the previous: `dp_max[i] = dp_max[i-1]*nums[i]`
   * Case 2b: the resultant product is smaller than the previous. So we keep it in `dp_min[i]`, hoping for a negative number to come by and flip the sign of this and possibly exceed `dp_max[i]`. So, `dp_min[i] = dp_max[i-1]*nums[i]`.

## DP Recurrence
So for each `i`, we check which of these cases result in the max `dp_max[i]` and the min `dp_min[i]`. The final recurrence is as follows:
```
dp_max[i] = max(nums[i], dp_max[i-1]*nums[i], dp_min[i-1]*nums[i])
dp_min[i] = min(nums[i], dp_min[i-1]*nums[i], dp_max[i-1]*nums[i])
dp_max[0] = nums[0]
dp_min[0] = nums[0]
```

## Final answer
The final answer is the max of `dp_max` array.

## Complexity
Time: `O(log n)`
Space: `O(log n)`

### Space Optimization
You can optimize space complexity to constant `O(1)` by just storing `dp_max[i]` and `dp_min[i]` and updating them. You don't need `dp_max[1..i-1]` when processing `i`.

Time: `O(log n)`
Space: `O(log n)`

## Examples
1. 
```
nums [-1,-2, 3, -2, -1]
dp_max [-1, 2, 6, 12, 12]
dp_min [-1,-2,-6,-12,-12]
ans = 12
```
2. 
```
nums [ 1, 2,-3,  2,  1]
dp_max [ 1, 2,-3,  2,  2]
dp_min [ 1, 2,-6,-12,-12]
ans = 2
```

