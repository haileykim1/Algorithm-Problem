import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var N = 0
var M = 0
var arr = intArrayOf()
var sb = StringBuilder()
var ans = intArrayOf()
var set = mutableSetOf<String>()

fun Pick(x: Int, last: Int){
    if(x == M - 1){
        set.add(ans.joinToString(" "))
        return
    }
    for(i in last..N - 1){
        ans[x + 1] = arr[i]
        Pick(x + 1, i)
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var tok = StringTokenizer(readLine())
    N = tok.nextToken().toInt()
    M = tok.nextToken().toInt()
    tok = StringTokenizer(readLine())
    arr = IntArray(N)
    for(i in 0..N - 1)
        arr[i] = tok.nextToken().toInt()
    arr.sort()

    ans = IntArray(M){0}
    Pick(-1, 0)

    var sb = StringBuilder()
    set.toList().forEach{
        sb.append(it)
        sb.append("\n")
    }
    print(sb.toString())
}