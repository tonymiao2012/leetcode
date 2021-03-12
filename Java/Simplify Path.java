public class Solution {
    public String simplifyPath(String path) {
        Deque<String> s = new ArrayDeque<String>();
        Set<String> set = new HashSet<>(Arrays.asList("",".",".."));
        
        String[] p = path.split("/");
        
        for(String dir : p){
            if(dir.equals("..") && !s.isEmpty())
                s.pop();
            else if(!set.contains(dir))
                s.push(dir);
        }
        
        String newPath = "";
        for(String dir : s) newPath = "/" + dir + newPath;
        
        return newPath.isEmpty() ? "/" : newPath;   //Deal with empty string. 
    }
}