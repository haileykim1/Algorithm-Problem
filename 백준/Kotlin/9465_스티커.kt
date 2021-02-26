import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max
/*
var arr = Array<IntArray>(2, {intArrayOf()})
var dp = Array(2, {intArrayOf()})

fun DP(x:Int, y:Int):Int{
    if(dp[x][y] != -1)
        return dp[x][y]


    if(x == 0)
        dp[x][y] = max(DP(1, y - 1),  DP(1, y - 2)) + arr[x][y]
    else
        dp[x][y] = max(DP(0, y - 1), DP(0, y - 2)) + arr[x][y]
    return dp[x][y]
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var tok = StringTokenizer(readLine())
    val T = tok.nextToken().toInt()
    for(i in 1..T){
        tok = StringTokenizer(readLine())
        val n = tok.nextToken().toInt()
        arr[0] = IntArray(n + 1)
        dp[0] = IntArray(n + 1){-1}
        arr[1] = IntArray(n + 1)
        dp[1] = IntArray(n + 1){-1}

        tok = StringTokenizer(readLine())
        for (i in 1..n)
            arr[0][i] = tok.nextToken().toInt()
        tok = StringTokenizer(readLine())
        for (i in 1..n)
            arr[1][i] = tok.nextToken().toInt()
        dp[0][0] = 0
        dp[1][0] = 0
        dp[0][1] = arr[0][1]
        dp[1][1] = arr[1][1]

        println(max(DP(0, n), DP(1, n)))
    }
}*/