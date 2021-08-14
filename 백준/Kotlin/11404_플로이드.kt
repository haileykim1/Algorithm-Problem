import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val m = readLine().toInt()
    val dist = Array(n + 1){IntArray(n + 1){10000000} }
    for(i in 1..m){
        val tok = StringTokenizer(readLine())
        val a = tok.nextToken().toInt()
        val b = tok.nextToken().toInt()
        val c = tok.nextToken().toInt()
        if(dist[a][b] > c)
            dist[a][b] = c
    }
    for(i in 1..n)
        dist[i][i] = 0

    for(k in 1..n){
        for(i in 1..n){
            for(j in 1..n){
                if(dist[i][k] + dist[k][j] < dist[i][j])
                    dist[i][j] = dist[i][k] + dist[k][j]
            }
        }
    }

    for(i in 1..n){
        for(j in 1..n){
            if(dist[i][j] == 10000000)
                print("0 ")
            else
                print("${dist[i][j]} ")
        }
        print("\n")
    }
}