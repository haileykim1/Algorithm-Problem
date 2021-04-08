import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

var N = 0
var M = 0
var bridge = Array(101){IntArray(101){101} }

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var tok = StringTokenizer(readLine())
    N = tok.nextToken().toInt()
    M = tok.nextToken().toInt()

    for(i in 1..M){
        tok = StringTokenizer(readLine())
        val a = tok.nextToken().toInt()
        val b = tok.nextToken().toInt()
        bridge[a][b] = 1
        bridge[b][a] = 1
    }
    for(i in 1..N)
        bridge[i][i] = 0

    //k 매개
    for(k in 1..N){
        for(i in 1..N - 1){
            for(j in i + 1..N){
                bridge[i][j] = min(bridge[i][j], bridge[i][k] + bridge[k][j])
                bridge[j][i] = bridge[i][j]
            }
        }
    }

    var minCnt = 101
    var minPerson = 0

    for(i in 1..N){
        bridge[i][0] = 0
        for(j in 1..N){
            bridge[i][0] += bridge[i][j]
        }
        if(bridge[i][0] < minCnt){
            minCnt = bridge[i][0]
            minPerson = i
        }
    }


    print("$minPerson\n")
}