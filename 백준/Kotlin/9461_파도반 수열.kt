import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
/*
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val T = readLine().toInt()
    var dp = LongArray(101)
    var dpInit = arrayOf(0, 1, 1, 1, 2, 2,3,4, 5, 7, 9)
    for(i in 1..10)
        dp[i] = dpInit[i].toLong()

    for(i in 11..100)
        dp[i] = dp[i - 1] + dp[i - 5]

    for (i in 1..T){
        val N = readLine().toInt()
        println(dp[N])

    }
}*/