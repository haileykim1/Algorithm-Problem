import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

var N = 0
var DP = intArrayOf()

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    N = readLine().toInt()
    DP = IntArray(N + 1){0}
    var endDay = IntArray(N + 1)
    var price = IntArray(N + 1)

    for(i in 1..N){
        var tok = StringTokenizer(readLine())
        endDay[i] = i + tok.nextToken().toInt() - 1
        price[i] = tok.nextToken().toInt()
    }

    for(i in 1..N){
        DP[i] = max(DP[i - 1], DP[i])
        if(endDay[i] <= N){
            DP[endDay[i]] = max(DP[endDay[i]], DP[i - 1] + price[i])
        }
    }

    print("${DP[N]}\n")
}