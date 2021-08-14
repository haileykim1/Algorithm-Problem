import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
var N = 0
var M = 0
var arr = intArrayOf()
var ans = intArrayOf()
var sb = StringBuilder()

fun Pick(x: Int, last: Int){
    if(x == M){
        for(i in 1..M){
            sb.append(ans[i])
            sb.append(" ")
        }
        sb.append("\n")
        return
    }
    for(i in last..N){
        ans[x + 1] = arr[i]
        Pick(x + 1, i)
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var tok = StringTokenizer(readLine())
    N = tok.nextToken().toInt()
    M = tok.nextToken().toInt()
    tok = StringTokenizer(readLine())
    arr = IntArray(N + 1)
    ans = IntArray(M + 1)
    arr[0] = 0
    for(i in 1..N)
        arr[i] = tok.nextToken().toInt()

    arr.sort()
    Pick(0, 1)

    print(sb.toString())
}