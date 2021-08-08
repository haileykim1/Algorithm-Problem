import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var N = 0
var M = 0
var edge = arrayOf<ArrayList<Pair<Int, Int>>>()
var A = 0
var B = 0
var dist = intArrayOf()

fun Dijkstra(): Int{
    dist[A] = 0
    var pq = PriorityQueue(Comparator<Pair<Int, Int>>{a, b -> a.second - b.second})
    pq.add(Pair(A, 0))

    while(pq.isNotEmpty()){
        val now = pq.peek().first
        val cost = pq.peek().second
        pq.poll()
        if(cost <= dist[now]){
            edge[now].forEach{
                val e = it.first
                val c = it.second
                if(dist[e] > dist[now] + c){
                    dist[e] = dist[now] + c
                    pq.add(Pair(e, dist[e]))
                }
            }
        }
    }


    return dist[B]
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    N = readLine().toInt()
    M = readLine().toInt()
    edge = Array(N + 1){ArrayList<Pair<Int, Int>>()}
    repeat(M){
        val tok = StringTokenizer(readLine())
        edge[tok.nextToken().toInt()].add(Pair(tok.nextToken().toInt(), tok.nextToken().toInt()))
    }
    val tok = StringTokenizer(readLine())
    A = tok.nextToken().toInt()
    B = tok.nextToken().toInt()
    dist = IntArray(N + 1){100000000}


    print("${Dijkstra()}\n")
}