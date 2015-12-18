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
        DFS(hm, node);
        
        return head;
        
    }
     public void DFS(HashMap<UndirectedGraphNode, UndirectedGraphNode> hm, UndirectedGraphNode node){
         if(node == null)
             return;
             
         for(UndirectedGraphNode aneighbor: node.neighbors){ 
             if(!hm.containsKey(aneighbor)){
                 UndirectedGraphNode newneighbor = new UndirectedGraphNode(aneighbor.label);
                 hm.put(aneighbor, newneighbor);
                 DFS(hm, aneighbor);//DFS
             }
             hm.get(node).neighbors.add(hm.get(aneighbor));
         }
     }
    
}