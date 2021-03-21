/**
 * @param {string} s
 * @return {string}
 */
 var longestPalindrome = function(s) {
    if(!s) {
        return s
    }
    // 首尾指针计算
    let i = 0, len = s.length, j = len - 1, lastJ = len - 1
    let longest = ""
    for(i; i< len; i++){
        let cur = s[i]
        // 反向找第一个元素，且下标不小于i
        while(j > i) {
            if(s[j] !== s[i]) {
                j -= 1
                continue
            }
            if(isPalindrome(i, j, s)) {
                let curLen = longest.length
                let tmpLen = s.substring(i, j + 1).length
                
                tmpLen > curLen ? longest = s.substring(i, j + 1) : longest = longest
            }
            //继续下一个记录位置的遍历
            j -= 1
        }
        // 如果一个字符都没匹配到，可以设置单元素的palindrome
        if(!longest) {
            longest = s[i]
        }
        j = len - 1
    }

    return longest
};

const isPalindrome = function(i, j, s) {
    while(i < j) {
        if(s[i] !== s[j]) {
            return false
        }
        i += 1
        j -= 1
    }
    return true
}

const main = function() {
    const testcase = "a"
    let res = longestPalindrome(testcase)
    console.log(res)
}

main()