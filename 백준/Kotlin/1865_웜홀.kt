import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val TC = readLine().toInt()
    var tok : StringTokenizer
    var sb = StringBuilder()

    loop@for (tc in 1..TC){
        tok = StringTokenizer(readLine())
        val N = tok.nextToken().toInt()
        val M = tok.nextToken().toInt()
        val W = tok.nextToken().toInt()
        var edge = ArrayList<Pair<Int, Pair<Int, Int>>>()
        var dist = IntArray(N + 1){5000001}

        if(W == 0){
            sb.append("NO\n")
            continue@loop
        }
        for(i in 1..M){
            tok = StringTokenizer(readLine())
            var a = tok.nextToken().toInt()
            var b = tok.nextToken().toInt()
            var c = tok.nextToken().toInt()
            edge.add(Pair(a, Pair(b, c)))
            edge.add(Pair(b, Pair(a, c)))
        }
        for(i in 1..W){
            tok = StringTokenizer(readLine())
            var a = tok.nextToken().toInt()
            var b = tok.nextToken().toInt()
            var c = -tok.nextToken().toInt()
            edge.add(Pair(a, Pair(b, c)))
        }

        dist[1] = 0
        var hasYes = false
        for(i in 1..N - 1){
            var isUpdated = false
            for(j in 0..edge.size - 1){
                val s = edge[j].first
                val e = edge[j].second.first
                val c = edge[j].second.second
                if(dist[e] > dist[s] + c){
                    dist[e] = dist[s] + c
                    isUpdated = true
                }
            }
            if(!isUpdated)
                break
        }

        for(i in 0..edge.size - 1){
            val s = edge[i].first
            val e = edge[i].second.first
            val c = edge[i].second.second
            if(dist[e] > dist[s] + c){
                hasYes = true
                break
            }
        }
        if(hasYes)
            sb.append("YES\n")
        else
            sb.append("NO\n")

    }
    print(sb.toString())
}