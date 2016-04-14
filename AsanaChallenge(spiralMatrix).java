package matrix;

import java.util.ArrayList;
import java.util.List;

public class spiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix){
        List<Integer> result = new ArrayList<Integer>();
        if(matrix.length == 0){
            return result;
        }
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        
        while(rowStart <= rowEnd && colStart <= colEnd){
            for(int i = colStart; i <= colEnd; i++){
                result.add(matrix[rowStart][i]);
            }
            rowStart++;
            
            for(int i = rowStart; i <= rowEnd; i++){
                result.add(matrix[i][colEnd]);
            }
            colEnd--;
            
            if(rowStart <= rowEnd){
                for(int i = colEnd; i >= colStart; i--){
                    result.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;
            
            if(colStart <= colEnd){
                for(int i = rowEnd; i >= rowStart; i--){
                    result.add(matrix[i][colStart]);
                }
            }
            colStart++;
        }
        
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[][] matrix = {{11, 12, 13, 14, 15},{21, 22, 23, 24, 25},{31, 32, 33, 34, 35},{41, 42, 43, 44, 45}};
        
        List<Integer> res = spiralOrder(matrix);
        
        for(int i : res){
            System.out.print(i + " ");
        }
	}

}
