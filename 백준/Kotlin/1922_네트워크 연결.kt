import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var N = 0
var M = 0
var cost = arrayOf<ArrayList<Pair<Int, Int>>>()
var visited = booleanArrayOf()
var ans = 0
var connCnt = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    N = readLine().toInt()
    M = readLine().toInt()
    cost = Array(N + 1){ArrayList<Pair<Int, Int>>()}
    visited = BooleanArray(N + 1){false}
    repeat(M){
        val tok = StringTokenizer(readLine())
        val a = tok.nextToken().toInt()
        val b = tok.nextToken().toInt()
        val c = tok.nextToken().toInt()
        cost[a].add(Pair(b, c))
        cost[b].add(Pair(a, c))
    }
    var pq = PriorityQueue(Comparator<Pair<Int, Int>>{a, b -> a.second - b.second})
    pq.add(Pair(1, 0))
    while(connCnt < N){
        val now = pq.poll()
        val node = now.first
        val dist = now.second
        if(!visited[node]){
            visited[node] = true
            ++connCnt
            ans += dist
            cost[node].forEach{
                if(!visited[it.first]){
                    pq.add(Pair(it.first, it.second))
                }
            }
        }
    }
    print("$ans\n")
}