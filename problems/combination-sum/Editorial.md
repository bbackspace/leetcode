Let's define a function `f(x)` where f returns all the unique combinations, `x` is the `target` and let's rename `candidates[]` as `a[]` for brevity.

```
f(x) = collect(for each a[i] <= x, union(f(x - a[i]), {a[i]}))
f(0) = {}
```

where
```
{} = empty set.
{a[i]} is a singleton set containing a[i].
collect(set1, set2, ...) returns a list of all sets.
```

