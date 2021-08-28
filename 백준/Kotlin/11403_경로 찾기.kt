import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val N = readLine().toInt()
    var dist = Array(N + 1){IntArray(N + 1){100} }

    for(i in 1..N){
        val tok = StringTokenizer(readLine())
        for(j in 1..N){
            val cost = tok.nextToken().toInt()
            if(cost == 1)
                dist[i][j] = 1
        }
    }

    for(k in 1..N){
        for(i in 1..N){
            for(j in 1..N){
                if(dist[i][k] + dist[k][j] < dist[i][j])
                    dist[i][j] = dist[i][k] + dist[k][j]
            }
        }
    }
    var sb = StringBuilder()
    for(i in 1..N){
        for(j in 1..N){
            if(dist[i][j] == 100)
                sb.append("0 ")
            else
                sb.append("1 ")
        }
        sb.append("\n")
    }
    print(sb.toString())
}