import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

var N = 0
var E = 0
var cost = arrayOf<ArrayList<Pair<Int, Int>>>()
var v1 = 0
var v2 = 0
//0 : 1~노드 , 1: v1~노드, 2: v2~노드
var dist = arrayOf<IntArray>()

fun Dijkstra(x:Int,  option:Int){
    var pq = PriorityQueue(Comparator<Pair<Int, Int>>{a, b -> a.second - b.second})
    pq.add(Pair(x, 0))
    while(pq.isNotEmpty()){
        val s = pq.peek().first
        val e = pq.peek().second


        pq.poll()
        if(e <= dist[option][s]){
            cost[s].forEach{
                if(dist[option][it.first] > it.second + dist[option][s]){
                    dist[option][it.first] = it.second + dist[option][s]
                    pq.add(Pair(it.first, dist[option][it.first]))
                }
            }
        }
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var tok = StringTokenizer(readLine())
    N = tok.nextToken().toInt()
    E = tok.nextToken().toInt()
    cost = Array(N + 1){ArrayList<Pair<Int, Int>>()}
    dist = Array(3){IntArray(N + 1){800001} }
    for(i in 1..E){
        tok = StringTokenizer(readLine())
        val a = tok.nextToken().toInt()
        val b = tok.nextToken().toInt()
        val c = tok.nextToken().toInt()
        cost[a].add(Pair(b, c))
        cost[b].add(Pair(a, c))
    }
    tok = StringTokenizer(readLine())
    v1 = tok.nextToken().toInt()
    v2 = tok.nextToken().toInt()
    dist[0][1] = 0
    dist[1][v1] = 0
    dist[2][v2] = 0

    Dijkstra(1, 0)
    Dijkstra(v1, 1)
    Dijkstra(v2, 2)

    val ans = min(dist[0][v1] + dist[1][v2] + dist[2][N], dist[0][v2] + dist[2][v1] + dist[1][N])
    if(ans >= 800001){
        print("-1\n")
    }else{

        print("$ans\n")
    }





}