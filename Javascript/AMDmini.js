const def = new Map()

const defaultOptions = {
    paths: ''
}

// from CDN
const __import = (url) => {
    return new Promise((resolve, reject) => {
        System.import(url).then(resolve, reject)
    })
}

const __load = (url) => {
    return new Promise((resolve, reject) => {
        const head = document.getElementsByTagName('head')[0]
    })
}

rj = {}

rj.config = (options) => Object.assign(defaultOptions, options)

// 定义模块，触发的时机其实是在require的时候
define = (name, deps, factory) => {
    // Todo: 参数的判断，互换
    def.set(name, { name, deps, factory })
}

// 此处才是触发加载依赖的地方
require = (deps, factory) => {
    return new Promise((resolve, reject) => {
        Promise.all(deps.map(dep => {
            if(defaultOptions.paths[dep]){
                return __import(defaultOptions.paths[dep])
            }

            return __load(__getUrl(dep)).then(() => {
                const { deps, factory } = def.get(dep)
                
            })
        })).then(resolve, reject)
    })
    .then(instances => factory(...instances))
}