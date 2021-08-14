import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
var N = 0
var M = 0
var arr = intArrayOf()
var ans = intArrayOf()
var visited = booleanArrayOf()
var sb = StringBuilder()

fun Permutation(x: Int){
    if(x == M){
        for(i in 1..M){
            sb.append(ans[i])
            sb.append(" ")
        }
        sb.append("\n")
        return
    }
    for(i in 1..N){
        if(!visited[i]){
            visited[i] = true
            ans[x + 1] = arr[i]
            Permutation(x + 1)
            visited[i] = false
        }
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var tok = StringTokenizer(readLine())
    N = tok.nextToken().toInt()
    M = tok.nextToken().toInt()
    tok = StringTokenizer(readLine())
    arr = IntArray(N + 1)
    visited = BooleanArray(N + 1){false}
    ans = IntArray(M + 1)
    arr[0] = 0
    for(i in 1..N)
        arr[i] = tok.nextToken().toInt()

    arr.sort()
    Permutation(0)

    print(sb.toString())
}