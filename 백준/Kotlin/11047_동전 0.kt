import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var N = 0
var K = 0
var arr = intArrayOf()

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val tok= StringTokenizer(readLine())
    N = tok.nextToken().toInt()
    K = tok.nextToken().toInt()
    arr = IntArray(N + 1)
    var ans = 0
    for(i in 0..N - 1)
        arr[i] = readLine().toInt()
    arr[N] = 100000001
    var left = K
    var cur = 0
    while(arr[cur] <= K)
        ++cur

    while(left > 0 && cur > 0){
        var coins = left / arr[--cur]
        left -= arr[cur] * coins
        ans += coins
    }
    print("$ans\n")
}