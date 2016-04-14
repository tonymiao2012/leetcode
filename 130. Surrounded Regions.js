/**
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var solve = function(board) {
    var m = board.length, n, i, j, queue = [];
    for(i = 0; i < m; i++){
        n = board[0].length;
        for(j = 0; j < n; j++){
            if(board[i][j] === 'O' && (i === 0 || i === m - 1 || j === 0 || j === n - 1)){
                queue.push({row: i, col: j});
            }
        }
    }
    
    bfs(queue);
    
    for(i = 0; i < m; i++){
        for(j = 0; j < n; j++){
            if(board[i][j] === 'O'){
                board[i][j] = 'X';
            }
            if(board[i][j] === 'C'){
                board[i][j] = 'O';
            }
        }
    }
    
    function bfs(queue){
        var i, j, len = queue.length, curr;
        
        while(queue.length > 0){
            curr = queue.shift();
            i = curr.row, j = curr.col;
            if(board[i][j] === 'C'){
                continue;
            }
            board[i][j] = 'C';
            if(board[i + 1] && board[i + 1][j] && board[i + 1][j] === 'O'){
                queue.push({row : i + 1, col : j});
            }
            if(board[i - 1] && board[i - 1][j] && board[i - 1][j] === 'O'){
                queue.push({row : i - 1, col : j});
            }
            if(board[i][j + 1] && board[i][j + 1] === 'O'){
                queue.push({row : i, col : j + 1});
            }
            if(board[i][j - 1] && board[i][j - 1] === 'O'){
                queue.push({row : i, col : j - 1});
            }
        }
    }
};