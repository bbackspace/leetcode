If a rectangle is defined with the following points with (x, y) coordinates,
```
rect r {
bottomleft: x1,y1
topright: x2,y2
}
```

```
isOverlap(r1, r2) = max(r1.x1, r2.x1) < min(r1.x2, r2.x2) && max(r1.y1, r2.y1) < min(r1.y2,r2.y2)
overlap_x(r1, r2) = min(r1.x2, r2.x2) - max(r1.x1, r2.x1)
overlap_y(r1, r2) = min(r1.y2,r2.y2) - max(r1.y1, r2.y1)
maxSq(r1, r2) = min(overlap_x(r1, r2), overlap_y(r1, r2))
```
