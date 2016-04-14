/**
 * @param {character[]} str
 * @return {void} Do not return anything, modify the string in-place instead.
 */
var reverseWords = function(str) {
    var start = 0, end = str.length, len = str.length;
    swap(str, 0, len - 1);
    
    var i, j;
    for (i = 0, j = 0; j < len; j++) {
        if (str[j] === ' ') {
            swap(str, i, j - 1);
            i = j + 1;
        }
    }
    swap(str, i, len - 1);
    
    function swap(str, start, end){
        var s = start, e = end;
        while(s < e){
            var tmp = str[s];
            str[s] = str[e];
            str[e] = tmp;
            s++;
            e--;
        }
    }
};