/**
 * Encodes a list of strings to a single string.
 *
 * @param {string[]} strs
 * @return {string}
 */
var encode = function(strs) {
    var res = [], tmp = "";
    for(tmp in strs){
        res.push(tmp.length + '/' + tmp);
    }
    return res.toString();
};

/**
 * Decodes a single string to a list of strings.
 *
 * @param {string} s
 * @return {string[]}
 */
var decode = function(s) {
    var strs = [], size, slash, i = 0;
    while(i < s.length){
        slash = s.indexOf('/', i);
        size = Number(s.substring(i, slash));
        strs.push(s.substring(slash + 1, slash + size + 1));
        i = slash + size + 1;
    }
    
    return strs;
};

/**
 * Your functions will be called as such:
 * decode(encode(strs));
 */