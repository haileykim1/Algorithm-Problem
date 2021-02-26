import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
/*
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val N = readLine().toInt()

    var dp = IntArray(31)
    dp[0] = 1
    dp[1] = 0
    dp[2] = 3
    dp[3] = 0
    //dp[4] = 11
    //dp[5] = 0
    for(i in 4..N){
        dp[i] = 4 * dp[i - 2] - dp[i - 4]
    }
    println(dp[N])

}*/