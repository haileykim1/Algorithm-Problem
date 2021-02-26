import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max
/*
var N:Int = 0
var arr = IntArray(301)
var dp = IntArray(301){-1}

fun DP(x:Int):Int{
    if(dp[x] != -1)
        return dp[x]

    dp[x] = max(DP(x - 3) + arr[x - 1], DP(x - 2)) + arr[x]
    return dp[x]
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    N = readLine().toInt()
    for(i in 1..N)
        arr[i] = readLine().toInt()

    dp[0] = 0
    dp[1] = arr[1]
    dp[2] = arr[1] + arr[2]
    println(DP(N))

}*/