import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var V = 0
var E = 0
var edge = arrayOf<ArrayList<Pair<Int, Int>>>()
var selected = booleanArrayOf()
var selectedCnt = 1
var ans = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var tok = StringTokenizer(readLine())
    V = tok.nextToken().toInt()
    E = tok.nextToken().toInt()
    edge = Array(V + 1){ArrayList<Pair<Int, Int>>()}
    selected = BooleanArray(V + 1){false}
    selected[1] = true

    repeat(E){
        tok = StringTokenizer(readLine())
        val a = tok.nextToken().toInt()
        val b = tok.nextToken().toInt()
        val c = tok.nextToken().toInt()
        edge[a].add(Pair(b, c))
        edge[b].add(Pair(a, c))

    }

    var pq = PriorityQueue(Comparator<Pair<Int, Pair<Int, Int>>>{a, b -> a.second.second - b.second.second})
    edge[1].forEach{
        pq.add(Pair(1, it))
    }

    while(selectedCnt < V){
        val now = pq.poll()
        if(!selected[now.second.first]){
            val a = now.first
            val b = now.second.first
            val c = now.second.second
            selected[b] = true
            edge[b].forEach{
                pq.add(Pair(b, it))
            }
            ++selectedCnt
            ans += c
        }
    }

    print("$ans\n")
}