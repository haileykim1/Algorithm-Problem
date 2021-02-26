import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max
/*
var arr = intArrayOf()
var dp = intArrayOf()

fun DP(x:Int):Int{
    if(dp[x] != -1)
        return dp[x]

    dp[x] = max(DP(x - 2), DP(x - 3) + arr[x - 1]) + arr[x]
    dp[x] = max(DP(x - 1), dp[x])
    return dp[x]
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()

    arr = IntArray(n + 2){0}
    dp = IntArray(n + 2){-1}
    for(i in 1..n)
        arr[i] = readLine().toInt()
    dp[0] = 0
    dp[1] = arr[1]
    dp[2] = arr[1] + arr[2]

    println(DP(n))
}*/