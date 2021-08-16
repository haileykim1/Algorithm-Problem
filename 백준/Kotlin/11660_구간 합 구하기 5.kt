import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var tok = StringTokenizer(readLine())
    val N = tok.nextToken().toInt()
    val M = tok.nextToken().toInt()
    var preSum = Array(N + 1){IntArray(N + 1){0} }
    for(i in 1..N){
        tok = StringTokenizer(readLine())
        for(j in 1..N){
            preSum[i][j] = preSum[i][j - 1] + tok.nextToken().toInt()
        }
    }
    for(i in 2..N){
        for(j in 1..N){
            preSum[i][j] += preSum[i - 1][j]
        }
    }

    for(i in 1..M){
        tok = StringTokenizer(readLine())
        val x1 = tok.nextToken().toInt()
        val y1 = tok.nextToken().toInt()
        val x2 = tok.nextToken().toInt()
        val y2 = tok.nextToken().toInt()
        val ans = preSum[x2][y2] - preSum[x1 - 1][y2] - preSum[x2][y1 - 1] + preSum[x1 - 1][y1 - 1]
        print("$ans\n")
    }

}