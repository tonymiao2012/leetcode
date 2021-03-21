/**
 * @param {number[]} flowerbed
 * @param {number} n
 * @return {boolean}
 */
 var my_canPlaceFlowers = function(flowerbed, n) {
    if(!flowerbed) {
        return false
    }
    if(n === 0) {
        return true
    }
    // 数组计算，如果遇到0，进行+1计算，然后继续；如果遇到1，进行结算
    let res = 0, len = flowerbed.length, sum = 0
    for(let i = 0; i < len; i++) {
        if(flowerbed[i] === 0) {
            res += 1
            continue
        }
        // 如果不是0，那么提取当前的可用值，然后累加，比较是否满足n。满足返回true，不满足继续
        let tmp = flowerbed[0] === 0 ? Math.floor(res / 2) : Math.floor((res - 1) / 2)
        res = 0
        if(tmp > 0) {
            sum += tmp
            if(sum >= n) {
                return true
            }
        }
    }
    if(res > 0) {
        let tmp = Math.floor(res / 2)
        if(tmp > 0) {
            sum += tmp
            if(sum >= n) {
                return true
            }
        }
    }
    return false
};
// 题解做法
var canPlaceFlowers = function(flowerbed, n) {
    let count = 0
    const len = flowerbed.length
    let prev = -1

    for(let i = 0; i < len; i++) {
        if(flowerbed[i] === 1) {
            if(prev < 0) {
                count += Math.floor(i / 2)
            } else {
                count += Math.floor((i - prev - 2) / 2)
            }
            prev = i
        }
    }

    if(prev < 0) {
        // 全是0的数组
        count += Math.floor((len + 1) / 2)
    } else {
        // 尾部为0s的部分处理
        count += Math.floor((len - prev - 1) / 2) 
    }

    return count >= n
}

const main = function() {
    const testcase = [1,0,0,0,1,0,0]
    let res = canPlaceFlowers(testcase, 2)
    console.log(res)
}

main()