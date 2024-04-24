import java.util.LinkedList;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1)
            return Collections.singletonList(0);
        int[] indegree = new int[n];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            indegree[u]++;
            indegree[v]++;
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v,k -> new ArrayList<>()).add(u);
        }
        List<Integer> result = new ArrayList<>();

        Queue<Integer> que = new LinkedList<>();
        for(int i =0; i< n ;i++){
            if(indegree[i] == 1){
                que.offer(i);
            }
        }
        while(n>2){
            int size = que.size();
            n -= size;
            while(size-- > 0){
                int u = que.poll();
                for(int v : adj.getOrDefault(u,Collections.emptyList())){
                    indegree[v]--;
                    if(indegree[v] == 1){
                        que.offer(v);
                    }
                }
            }
        }
        while(!que.isEmpty()){
            int u = que.poll();
            result.add(u);
        }
        return result;
    }
}