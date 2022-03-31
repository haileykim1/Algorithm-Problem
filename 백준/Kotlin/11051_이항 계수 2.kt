import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var N = 0
var K = 0
val DIV = 10007
var Combination = Array(1001){IntArray(1001){-1} }

fun nCk(n: Int, k: Int): Int{
    if(Combination[n][k] != -1){
        return Combination[n][k]
    }
    val ret = (nCk(n - 1, k - 1) + nCk(n - 1, k)) % DIV
    Combination[n][k] = ret
    return ret
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val NK = readLine().split(" ")
    N = NK[0].toInt()
    K = NK[1].toInt()
    for(i in 0..N){
        Combination[i][0] = 1
        Combination[i][i] = 1
    }

    print("${nCk(N, K)}\n")

}