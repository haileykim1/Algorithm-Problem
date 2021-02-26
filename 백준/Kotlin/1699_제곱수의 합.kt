import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min
/*
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var N = readLine().toInt()

    var ans:Int = 0

    //Bottom-up
    var dp = IntArray(N + 1)
    for(i in 1..N){
        dp[i] = i
        var j = 1
        while(j * j <= i){
            dp[i] = min(dp[i], dp[i - j * j] + 1)
            ++j
        }
    }
    println(dp[N])
}*/