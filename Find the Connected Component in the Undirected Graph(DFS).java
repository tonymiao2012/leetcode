/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nodes == null || nodes.size() == 0){
            return result;
        }
        Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        for(UndirectedGraphNode node : nodes){
            if(visited.contains(node))
                continue;
            List<Integer> temp = new ArrayList<Integer>();
            dfsHelper(node, visited, temp);
            Collections.sort(temp);
            if(!result.contains(temp)){
                result.add(temp);
            }
        }
        return result;
    }
    
    private void dfsHelper(UndirectedGraphNode node, 
                           Set<UndirectedGraphNode> visited,
                           List<Integer> temp){
                               
            temp.add(node.label);
            visited.add(node);
            for(UndirectedGraphNode n : node.neighbors){
                if(visited.contains(n))
                    continue;
                dfsHelper(n, visited, temp);
            }
        }
}