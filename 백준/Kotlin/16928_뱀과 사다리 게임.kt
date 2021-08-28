import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var N = 0
var M = 0
var map = IntArray(101){-1}
var dist = IntArray(101){100}

fun Relax(x: Int){
    val cost = dist[x]
    if(map[x] != -1){
        if(dist[map[x]] > cost){
            dist[map[x]] = cost
            Relax(map[x])
        }
    }else{
        for(i in 6 downTo 1){
            if((x + i) <= 100){
                if(dist[x + i] > cost + 1){
                    dist[x + i] = cost + 1
                    Relax(x + i)
                }
            }
        }
    }

}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var tok = StringTokenizer(readLine())
    N = tok.nextToken().toInt()
    M = tok.nextToken().toInt()

    repeat(N){
        tok = StringTokenizer(readLine())
        val a = tok.nextToken().toInt()
        val b = tok.nextToken().toInt()
        map[a] = b
    }
    repeat(M){
        tok = StringTokenizer(readLine())
        val a = tok.nextToken().toInt()
        val b = tok.nextToken().toInt()
        map[a] = b

    }

    dist[1] = 0
    Relax(1)
    print("${dist[100]}\n")
}