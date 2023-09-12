var x = 10;
var s = 'fsfsdf';
var arr = ["fdsfa", 89, [9, 8], { 'dfs': 'fdsa'}]

var f1 = function (some) {
    return function (s) {
        return some;
    }
}

var f2 = f1(f2());