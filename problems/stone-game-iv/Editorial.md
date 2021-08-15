### Approach
The following observations are crucial to identifying the strategy to solve this problem:
1. The winning result is independent of the player. When it's your turn, the number n will solely determine whether you will win or lose. For example, if n = 16 and it's Alice turn, Alice will always win, by removing 16 stones (perfect square). If it is Bob's turn at n = 16, he will win.
2. A function can be defined that takes `n` and returns true if Alice wins. This function's value can be found if we have the values for this function at `1..n-1`.
    1. `f(n) = true` if there is at least one possible move for `k` stones for which `f(n-k) = false`. `k` has to be a perfect square here.
    2. `f(n) = false` if every possible move for `k` stones leads to `f(n-k) = true`.

```
f(0) = false // Bob used a perfect square in the previous turn, so Alice is left with 0 and loses
f(1) = true // 1 is perfect square. Alice wins by removing 1 stone.
f(s) = true // where s is a perfect square
f(2) = !f(1) = false // Alice has to remove 1 stone since it is the only option. Then Bob wins by removing 1. The not operation is used when the turn switches.
f(5) = !f(5-1) || !f(5-4)
     = !f(4) || !f(1)
     = !true || !true
     = false
f(6) = !f(6-1) || !f(6-4)
     = !f(5) || !f(2)
     = true || true
     = true
f(10) = !f(10-1) || !f(10-4) || !f(10-9)
      = !f(9) || !f(6) || !f(1)
      = false
```

We have the recurrence, and we can reuse the answers for f(0) to f(n) to calculate f(n+1). Hence we have all the preconditions for DP.

### Complexity
Time complexity: `O(n√n)` since for n stones, we have upto `√n` options for moves. And in the worst case the depth of the recurrence tree is `n`.
Space complexity: `O(n)` to store n values for memoization and also the stack space.
