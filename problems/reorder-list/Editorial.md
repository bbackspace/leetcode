## Approach

1. Find the middle of the given linked list using fast and slow pointer method.
2. Then break the list into two at the mid position found in step 1.
3. Reverse the second half so that we have two lists, one from nodes 0, 1, 2, ... and other from nodes n-1, n-2, n-3, ...
4. Merge the two lists by picking one element each from both lists alternatively.
