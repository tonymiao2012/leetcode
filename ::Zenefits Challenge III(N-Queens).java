//Zenefits Challenge III, N-Queens

/*
 * Complete the function below.
 */

    static int maxThreats(int[] a) {
        if(a == null || a.length <= 1){
            return 0;
        }
        int len = a.length;
        int max = 0;
        
        for(int row = 0; row < len; row++){
            int curMax = 0;
            int col = a[row] - 1;
            curMax = getThreatsNum(row, col, a);
            max = Math.max(max, curMax);
            if(max == 4){
                return max;
            }
        }
        
        return max;
    }

    private static int getThreatsNum(int row, int col, int[] queens){
        int numThreats = 0;
        int n = queens.length;
        
        int i = row - 1;
        while(i >= 0 && (row - i != col - queens[i] + 1)){
            i--;
        }
        if(i >= 0){
            numThreats++;
        }
        i = row + 1;
        while(i < n && (i - row != queens[i] - 1 - col)){
            i++;
        }
        if(i < n){
            numThreats++;
        }
        i = row - 1;
        while(i >= 0 && (row - i != queens[i] - 1 - col)){
            i--;
        }
        if(i >= 0){
            numThreats++;
        }
        i = row + 1;
        while(i < n && (i - row) != col - queens[i] + 1){
            i++;
        }
        if(i < n){
            numThreats++;
        }
        
        return numThreats;
    }

