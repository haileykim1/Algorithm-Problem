import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

var dist = arrayOf<IntArray>()
var v1 = 0
var v2 = 0
var N = 0
var E = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var tok = StringTokenizer(readLine())
    N = tok.nextToken().toInt()
    E = tok.nextToken().toInt()
    dist = Array(N + 1){IntArray(N + 1){800000} }

    repeat(E){
        tok = StringTokenizer(readLine())
        val a = tok.nextToken().toInt()
        val b = tok.nextToken().toInt()
        val c = tok.nextToken().toInt()
        dist[a][b] = c
        dist[b][a] = c
    }
    tok = StringTokenizer(readLine())
    v1 = tok.nextToken().toInt()
    v2 = tok.nextToken().toInt()
    for(i in 1..N)
        dist[i][i] = 0

    for(k in 1..N){
        for(i in 1..N){
            for(j in 1..N){
                if(dist[i][k] + dist[k][j] < dist[i][j])
                    dist[i][j] = dist[i][k] + dist[k][j]
            }
        }
    }
    var temp1 = dist[v1][v2]
    var v1First = false
    var temp2 = dist[1][v2] + dist[v1][N]
    if(dist[1][v1] + dist[v2][N] < dist[1][v2] + dist[v1][N]){
        temp2 = dist[1][v1] + dist[v2][N]
    }
        v1First = true
        var temp3 = temp1 + temp2

    if(v1First && (dist[1][v1] >= 800000 || dist[v2][N] >= 800000 || temp1 >= 800000)){
        print("-1\n")
    }else if(!v1First && (dist[1][v2] >= 800000 || dist[v1][N] >= 800000 || temp1 >= 800000))
    else
        print("${temp3}\n")

}