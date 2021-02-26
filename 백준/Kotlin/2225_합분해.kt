import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
/*
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var tok = StringTokenizer(readLine())
    val N = tok.nextToken().toInt()
    val K = tok.nextToken().toInt()
    var dp = Array(201, {IntArray(201){1} })

    for(i in 2..200){
        for(j in 1..200){
            dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000000
        }
    }
    println(dp[K][N])

}*/