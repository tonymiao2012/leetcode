/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    var i, j, x, y, m = grid.length, n, count = 0;
    for(i = 0; i < m; i++){
        n = grid[0].length;
        for(j = 0; j < n; j++){
            if(grid[i][j] === '1'){
                count++;
                bfs([{row: i, col: j}]);
            }   
        }
    }
    
    return count;
    
    function bfs(queue){
        //Update 1s already counted.
        var len = queue.length, i, j, top;
        
        while(len--){
            top = queue.shift();
            i = top.row, j = top.col;
            if(grid[i] && grid[i][j] && grid[i][j] === '1'){
                grid[i][j] = '2';
                queue.push({row: i - 1, col: j});
                queue.push({row: i, col: j - 1});
                queue.push({row: i + 1, col: j});
                queue.push({row: i, col: j + 1});
            }
        }
        if(queue.length !== 0){
            bfs(queue);
        }
    }
};
