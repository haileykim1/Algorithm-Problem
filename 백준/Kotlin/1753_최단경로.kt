import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var V = 0
var E = 0
var K = 0
var edge = arrayOf<ArrayList<Pair<Int, Int>>>()
var dist = intArrayOf()

fun Dijkstra(){
    var pq = PriorityQueue(Comparator<Pair<Int, Int>>{a, b -> a.second - b.second})
    pq.add(Pair(K, 0))
    while(pq.isNotEmpty()){
        val s = pq.peek().first
        val c = pq.peek().second
        pq.poll()
        if(c <= dist[s]){
            edge[s].forEach {
                val n = it.first
                val w = it.second
                if(dist[s] + w < dist[n]){
                    dist[n] = dist[s] + w
                    pq.add(Pair(n, dist[n]))
                }
            }
        }
    }

}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var tok = StringTokenizer(readLine())
    V = tok.nextToken().toInt()
    E = tok.nextToken().toInt()
    K = readLine().toInt()
    edge = Array(V + 1){ArrayList<Pair<Int, Int>>()}
    dist = IntArray(V + 1){200001}
    for(i in 1..E){
        tok = StringTokenizer(readLine())
        edge[tok.nextToken().toInt()].add(Pair(tok.nextToken().toInt(), tok.nextToken().toInt()))
    }
    dist[K] = 0
    Dijkstra()
    var sb = StringBuilder()
    for(i in 1..V){
        if(dist[i] >= 200001){
            sb.append("INF\n")
        }else{
            sb.append("${dist[i]}\n")
        }
    }
    print(sb.toString())
}