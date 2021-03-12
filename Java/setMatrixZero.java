package leetcode;

import java.util.PriorityQueue;

public class setMatrixZero {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if(m == 0)
            return;
        int n = matrix[0].length;
        if(n == 0)
            return;
        //set row matrix and col matrix to judge zero.
        int[] row = new int[m];
        int[] col = new int[n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    row[i] = 0;
                    col[j] = 0;
                }
            }
        }
        //set matrix zero according to row[] and col[].
        for(int i = 0; i < m; i++){
            if(row[i] == 0){
                for(int j = 0; j < n; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(col[i] == 0){
                for(int j = 0; j < m; j++){
                    matrix[j][i] = 0;
                }
            }
        }
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[][] matrix = {[1],[1]};
		PriorityQueue p = new PriorityQueue();
	}

}
