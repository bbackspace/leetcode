## Approach
Sliding window.

1. Valid window is one with each number's frequency less than K. Use hash map to maintain window's frequency.
2. Extend window to the right by 1 each iteration. if the window is not valid anymore, keep reducing the window length from left until it does become valid again.
3. Record the max length of every new valid window.

Note that in step 2, to check if the window is valid again, we need not check the frequency of each key in the map. We only need to check for the key we just increased (rightmost end of the window), since that is the one that went beyond K and made the window invalid. As soon as the frequency for this key is below or equal to K, we stop since the window is now valid.
