const smallestK = function(arr, k) {
    if(!arr || !k) {
        return []
    }

    let res = [], len = arr.length, i = 0
    // res.push(Number.MAX_SAFE_INTEGER)

    while(i < len){
        const curResLen = res.length

        if(!curResLen) {
            res.push(arr[i])
            continue
        }

        if(arr[i] < res[curResLen - 1]) {
            arr = pushIntoArr(res, arr[i], k)
        }
    }

    return res
}

const pushIntoArr = function(arr, num, k) {
    const len = arr.length

    for(let i = 0; i < len; i++) {
        if(arr[i] < num && arr[i + 1] > num) {
            arr.splice(i,0, num)
        }
    }
    if(k > len) {
        return arr.slice(0, len)
    } else {
        return arr.slice(0, k)
    }
}

const main = function() {
    const testcase = [1,3,5,7,2,4,6,8]
    const k = 4

    let res = smallestK(testcase, 4)
    console.log(res)
}

main()