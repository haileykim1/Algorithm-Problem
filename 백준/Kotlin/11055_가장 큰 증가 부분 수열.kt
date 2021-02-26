import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max
/*
var arr = intArrayOf()
var dp = intArrayOf()

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val N = readLine().toInt()
    arr = IntArray(N + 1)
    dp = IntArray(N + 1)
    var tok = StringTokenizer(readLine())
    for(i in 1..N)
        arr[i] = tok.nextToken().toInt()
    dp[0] = 0
    var ans:Int = 0
    for(i in 1..N){
        for(j in 0..i - 1){
            if(arr[j] < arr[i]){
                dp[i] = max(dp[i], dp[j] + arr[i])
            }
        }
        ans = max(ans, dp[i])
    }
    println(ans)
}*/