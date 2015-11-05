package leetcode;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class test {
    public static int ladderLength(String start, String end, Set<String> dict) {
          // Use queue to help BFS
          Queue<String> queue = new LinkedList<String>();
          queue.add(start);
          queue.add(null);

          // Mark visited word
          Set<String> visited = new HashSet<String>();
          visited.add(start);

          int level = 1;

          while (!queue.isEmpty()) {
            String str = queue.poll();

            if (str != null) {
              // Modify str's each character (so word distance is 1)
              for (int i = 0; i < str.length(); i++) {
                char[] chars = str.toCharArray();

                for (char c = 'a'; c <= 'z'; c++) {
                  chars[i] = c;

                  String word = new String(chars);

                  // Found the end word
                  if (word.equals(end)) return level + 1;

                  // Put it to the queue
                  if (dict.contains(word) && !visited.contains(word)) {
                    queue.add(word);
                    visited.add(word);
                  }
                }
              }
            } else {
              level++;

              if (!queue.isEmpty()) { 
                queue.add(null);
              }
            }
          }

          return 0;
        }
    

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String begin = "qa";
        String end = "sq";
        Set<String> s = new HashSet<String>(Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"));
        
        System.out.println(ladderLength(begin,end,s));
    }

}
