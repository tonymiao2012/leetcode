package leetcode;

public class largestRectangleArea {

	public static int LargestRectangleArea(int[] height) {  
		  // Start typing your Java solution below  
		  // DO NOT write main() function  
		  int area = 0;  
		  java.util.Stack<Integer> heightStack = new java.util.Stack<Integer>();  
		  java.util.Stack<Integer> indexStack = new java.util.Stack<Integer>();  
		  for (int i = 0; i < height.length; i++) {  
		    if (heightStack.empty() || heightStack.peek() <= height[i]) {  
		      heightStack.push(height[i]);  
		      indexStack.push(i);  
		    } else if (heightStack.peek() > height[i]) {  
		      int j = 0;  
		      while (!heightStack.empty() && heightStack.peek() > height[i]) {  
		        j = indexStack.pop();  
		        int currArea = (i - j) * heightStack.pop();  
		        if (currArea > area) {  
		          area = currArea;  
		        }  
		      }  
		      heightStack.push(height[i]);  
		      indexStack.push(j);  
		    }  
		  }  
		  while (!heightStack.empty()) {  
		    int currArea = (height.length - indexStack.pop()) * heightStack.pop();  
		    if (currArea > area) {  
		      area = currArea;  
		    }  
		  }  
		  return area;  
		}  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {2,7,5,6,4};
		int max = largestRectangleArea.LargestRectangleArea(height);
		System.out.println(max);
	}

}
