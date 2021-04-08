import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var preSum = IntArray(100002){0}

    var tok = StringTokenizer(readLine())
    val N = tok.nextToken().toInt()
    val M = tok.nextToken().toInt()

    tok = StringTokenizer(readLine())
    for(i in 1..N){
        preSum[i] = preSum[i - 1] + tok.nextToken().toInt()
    }
    preSum[N + 1] = preSum[N]

    for(i in 1..M){
        tok = StringTokenizer(readLine())
        print("${0 - preSum[tok.nextToken().toInt() - 1] + preSum[tok.nextToken().toInt()]}\n")
    }
}