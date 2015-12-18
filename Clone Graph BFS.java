/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if(node == null){
            return null;
        }
        //DFS ways
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        hm.put(node, head);
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        
        while(!queue.isEmpty()){
            UndirectedGraphNode cur = queue.poll();
            //Deal with neighbors
            for(UndirectedGraphNode n : cur.neighbors){
                if(!hm.containsKey(n)){
                    queue.add(n);
                    UndirectedGraphNode newNode = new UndirectedGraphNode(n.label);
                    hm.put(n, newNode);
                }
                hm.get(cur).neighbors.add(hm.get(n));
            }
        }
        
        return head;
    }
}