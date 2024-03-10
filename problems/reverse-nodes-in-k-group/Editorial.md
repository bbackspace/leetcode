## Approach
1. Keep track of the current k-group `subList`. Move k spaces to find the tail and the start of the rest of the list.
2. Reverse the `subList`. Attach the head of the reversed subList after the previously processed list.
3. While moving k spaces, if the list ends, we want to attach the head of the subList without reversing and return.

## Techniques used
1. A dummy head node simplifies edge case handling where a previous pointer is needed to be maintained and the head might change after we're done.
