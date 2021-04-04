const modules = {}

const toUrl = (dep) => {
    const p = location.pathname
    return p.slice(0, p.lastIndexOf('/') + '/' + dep + '.js')

}

const getDepsFromFn = (fn) => {
    let matches = []
    let reg = /asd/g
    let r = null

    while(r = reg.exec(fn.toString()) !== null) {
        reg.lastIndex
        matches.push(reg[1])
    }

    return matches
}