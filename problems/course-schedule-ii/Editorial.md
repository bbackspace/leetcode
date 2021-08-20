## In-degree solution
### Approach
1. precalc all nodes' indegrees from given edge list
2. get all nodes with indegree 0. add it to a queue.
3. loop until queue is empty
    1. get a node X from queue
    2. add X to result
    3. delete its edges and decrease indegrees of the nodes it's adjacent to.
    4. if an adjacent node has indegree 0, add it to queue.
4. if result size is not n, not possible. return empty else return result

