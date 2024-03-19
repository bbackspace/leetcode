## Example
```
A 6
B 1
C 1
D 1
E 1
F 1
G 1

n = 2
```
```
ABCADEAFGA__A__A__
```

## Approach
$$(maxFreq - 1)*(n+1)+count(maxFreq)$$

where $maxFreq$ is the count of ith unique task with max frequency
