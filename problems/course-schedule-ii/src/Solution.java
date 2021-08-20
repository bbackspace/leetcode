class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Init data structures
        List<List<Integer>> adjList = new ArrayList<>();
        List<Integer> ind = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
            ind.add(0);
        }
        // calculate adjacency list and indegrees
        for (int j = 0; j < prerequisites.length; j++) {
            // x -> y edge
            int x = prerequisites[j][0];
            int y = prerequisites[j][1];
            adjList.get(x).add(y);
            ind.set(y, ind.get(y) + 1);
        }
        // init queue with all 0 indegree nodes
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (ind.get(i) == 0) {
                queue.add(i);
            }
        }
        
        // process
        List<Integer> result = new LinkedList<>();
        while (!queue.isEmpty()) {
            int x = queue.remove();
            result.add(0, x);
            for (int j = 0; j < adjList.get(x).size(); j++) {
                int indegree = ind.get(adjList.get(x).get(j));
                indegree--;
                if (indegree == 0) {
                    queue.add(adjList.get(x).get(j));
                }
                ind.set(adjList.get(x).get(j), indegree);
            }
            adjList.set(x, new ArrayList<>());
        }
        
        // detect cycles
        if (result.size() == numCourses) {
            return result.stream().mapToInt(x -> x).toArray();
        } else {
            return new int[0];
        }
    }
}

