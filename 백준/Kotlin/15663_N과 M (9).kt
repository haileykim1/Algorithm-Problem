import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var N = 0
var M = 0
var set = mutableSetOf<String>()
var arr = intArrayOf()
var visited = booleanArrayOf()
var ans = intArrayOf()

fun Pick(x: Int){
    if(x == M - 1){
        set.add(ans.joinToString(" "))
        return
    }
    for(i in 0..N - 1){
        if(!visited[i]){
            visited[i] = true
            ans[x + 1] = arr[i]
            Pick(x + 1)
            visited[i] = false
        }
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var tok = StringTokenizer(readLine())
    N = tok.nextToken().toInt()
    M = tok.nextToken().toInt()
    tok = StringTokenizer(readLine())
    arr = IntArray(N)
    ans = IntArray(M)
    visited = BooleanArray(N){false}
    for(i in 0..N - 1)
        arr[i] = tok.nextToken().toInt()
    arr.sort()
    Pick(-1)
    var sb = StringBuilder()

    set.toList().forEach{
        sb.append(it)
        sb.append("\n")
    }


    print(sb.toString())
}