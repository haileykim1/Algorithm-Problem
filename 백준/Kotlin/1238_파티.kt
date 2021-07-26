import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max
import kotlin.math.min

var N = 0
var M = 0
var X = 0
var cost = arrayOf<ArrayList<Pair<Int, Int>>>()
var costRev = arrayOf<ArrayList<Pair<Int, Int>>>()
var minDist = intArrayOf()
var ans = 0

fun dijkstra(x: Int, graph: Array<ArrayList<Pair<Int, Int>>>){
    var pq = PriorityQueue(Comparator<Pair<Int, Int>>{a, b ->
        a.second - b.second
    })
    var dist = IntArray(N + 1){10000000}
    dist[X] = 0
    pq.add(Pair(X, 0))
    for(i in 1..N){
        if(i != X){
            pq.add(Pair(i, 10000000))
        }
    }
    while(pq.isNotEmpty()){
        val s = pq.peek().first
        val e = pq.peek().second
        pq.poll()
        if(e <= dist[s]){
            graph[s].forEach{
                if(dist[s] + it.second < dist[it.first]){
                    dist[it.first] = dist[s] + it.second
                    pq.add(Pair(it.first, dist[it.first]))
                }
            }
        }
    }
    for(i in 1..N)
        minDist[i] += dist[i]
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var tok = StringTokenizer(readLine())
    N = tok.nextToken().toInt()
    M = tok.nextToken().toInt()
    X = tok.nextToken().toInt()
    cost = Array(N + 1){ArrayList<Pair<Int, Int>>()}
    costRev = Array(N + 1){ArrayList<Pair<Int, Int>>()}
    minDist = IntArray(N + 1){0}

    for(i in 1..M){
        tok = StringTokenizer(readLine())
        val s = tok.nextToken().toInt()
        val e = tok.nextToken().toInt()
        val c = tok.nextToken().toInt()
        cost[s].add(Pair(e, c))
        costRev[e].add(Pair(s, c))
    }

    dijkstra(X, cost)
    dijkstra(X, costRev)

    for(i in 1..N){
        ans = max(ans, minDist[i])
    }



    print("$ans\n")

}