import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

var N = 0
var cost = arrayOf<IntArray>()
var result = arrayOf<IntArray>()

fun Color(x: Int, prev: Int){
    if(x == N){
        return
    }
    for(i in 0..2){
        if(prev == i){
            continue
        }
        if(result[x][prev] + cost[x + 1][i] < result[x + 1][i]){
            result[x + 1][i] = result[x][prev] + cost[x + 1][i]
            Color(x + 1, i)
        }
    }

}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    N = readLine().toInt()
    cost = Array(N + 1){IntArray(3){0} }
    result = Array(N + 1){IntArray(4){1000001} }

    for(i in 1..N){
        val tok = StringTokenizer(readLine())
        for(j in 0..2){
            cost[i][j] = tok.nextToken().toInt()
        }
    }
    result[0][3] = 0
    Color(0,  3)

    var ans = min(min(result[N][0], result[N][1]), result[N][2])

    print("$ans\n")
}