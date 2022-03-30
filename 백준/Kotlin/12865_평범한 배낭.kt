import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

var maxValue = intArrayOf()
var N = 0
var K = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val NK = readLine().split(" ")
    N = NK[0].toInt()
    K = NK[1].toInt()
    maxValue = IntArray(K + 2){0}
    var maxi = 0
    repeat(N){
        val WV = readLine().split(" ")
        val W = WV[0].toInt()
        val V = WV[1].toInt()
        if (V > 0){
            for(i in K - W downTo 1){
                if(maxValue[i] != 0){
                    maxValue[i + W] = max(maxValue[i + W], maxValue[i] + V)
                    maxi = max(maxi, maxValue[i + W])
                }
            }
        }
        if(W <= K){
            maxValue[W] = max(maxValue[W], V)
            maxi = max(maxi, V)
        }
    }
    print("$maxi\n")

}