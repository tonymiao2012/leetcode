/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * };
 */
public class Solution {
   /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, 
                            DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here
        if(graph == null || graph.size() == 0 || s.neighbors == null){
            return false;
        }
        
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        queue.offer(s);
        while(!queue.isEmpty()){
            DirectedGraphNode cur = queue.poll();
            if(cur == t){
                return true;
            }
            for(DirectedGraphNode node : cur.neighbors){
                queue.offer(node);
            }
        }
        
        return false;
    }
}