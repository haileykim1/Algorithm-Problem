import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max
/*
var N:Int = 0
var arr = intArrayOf()
var dp = intArrayOf()

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    N = readLine().toInt()
    arr = IntArray(N + 1)
    dp = IntArray(N + 1)
    var tok = StringTokenizer(readLine())
    for(i in 1..N)
        arr[i] = tok.nextToken().toInt()

    //s부터 e까지 부분합이 최대라면 ?부터 s까지 부분합은 음수였다는 뜻. 즉 합이 음수면 버린다.

    dp[1] = arr[1]
    var ans:Int = arr[1]
    for(i in 2..N){
        dp[i] = max(dp[i - 1] + arr[i], arr[i])
        ans = max(ans, dp[i])
    }

    println(ans)
}*/