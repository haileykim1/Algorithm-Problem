import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

var N = 0
var DP = arrayOf<IntArray>()
var matrix = arrayOf<IntArray>()

fun calculate(x: Int, y: Int): Int{
    if(DP[x][y] != -1){
        return DP[x][y]
    }
    if(y == x + 1){
        DP[x][y] = matrix[x][0] * matrix[x][1] * matrix[y][1]
        return DP[x][y]
    }
    var ret = Integer.MAX_VALUE

    for(i in x + 1..y){
        ret = min(ret, calculate(x, i - 1) + calculate(i, y) + matrix[x][0] * matrix[i][0] * matrix[y][1])
    }

    DP[x][y] = ret
    return ret
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    N = readLine().toInt()
    DP = Array(N){IntArray(N){-1} }
    matrix = Array(N){IntArray(2)}
    for(i in 0..N - 1){
        val input = readLine().split(" ")
        matrix[i][0] = input[0].toInt()
        matrix[i][1] = input[1].toInt()
        DP[i][i] = 0
    }

    print("${calculate(0, N - 1)}\n")

}