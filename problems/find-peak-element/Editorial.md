### Approach
We're looking for a local maxima, ie., any peak in that is larger than its neighbours.

#### Binary Search
We take the `first=0`, `last=n-1` and `mid=(first+last)/2` indices of the `array[0..n-1]`.

There can be the following cases:
1. `array[mid]` is a local maxima. Return as ans.
2. `array[mid - 1]` > `array[mid]` > `array[mid + 1]`. Set `last=mid`
3. `array[mid - 1]` < `array[mid]` < `array[mid + 1]`. Set `first=mid`
4. `array[mid - 1]` > `array[mid]` < `array[mid + 1]`. Set `first=mid` or `last=mid` Both sides have a local maxima. We need only 1, so go in either direction.


