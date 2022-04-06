import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

var n = 0
var m = 0
var t = 0
var s = 0
var g = 0
var h = 0
var road = arrayOf<ArrayList<Pair<Int, Int>>>()
var tArr = intArrayOf()
var dist = arrayOf<IntArray>()
var ghDist = 0

fun Dijkstra(x: Int){
    var pq = PriorityQueue(Comparator<Pair<Int, Int>>{a, b -> a.second - b.second})
    pq.add(Pair(x, 0))
    while(pq.isNotEmpty()){
        val now = pq.peek().first
        val distance = pq.poll().second
        if(dist[x][now] >= distance){
            dist[x][now] = distance
            road[now].forEach{
                if(dist[x][now] + it.second < dist[x][it.first]){
                    dist[x][it.first] = dist[x][now] + it.second
                    pq.offer(Pair(it.first, dist[x][it.first]))
                }


            }
        }
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val T = readLine().toInt()
    val sb = StringBuilder()
    repeat(T){
        val nmt = readLine().split(" ")
        n = nmt[0].toInt()
        m = nmt[1].toInt()
        t = nmt[2].toInt()
        road = Array(n + 1){ArrayList<Pair<Int, Int>>()}
        dist = Array(n + 1){IntArray(n + 1){2000000}}
        val sgh = readLine().split(" ")
        s = sgh[0].toInt()
        g = sgh[1].toInt()
        h = sgh[2].toInt()
        repeat(m){
            val input = readLine().split(" ")
            val a = input[0].toInt()
            val b = input[1].toInt()
            road[a].add(Pair(b, input[2].toInt()))
            road[b].add(Pair(a, input[2].toInt()))
            if(((a == g) && (b == h)) || (a == h) && (b == g)){
                ghDist = input[2].toInt()
            }
        }
        tArr = IntArray(t)
        for(i in 0..t - 1){
            tArr[i] = readLine().toInt()
        }
        tArr.sort()
        Dijkstra(s)
        Dijkstra(g)
        Dijkstra(h)

        for(i in 0..t - 1){
            var isDestin = false
            if(dist[s][tArr[i]] == (dist[s][g] + ghDist + dist[h][tArr[i]])){
                isDestin = true
            }
            if(dist[s][tArr[i]] == (dist[s][h] + ghDist + dist[g][tArr[i]])){
                isDestin = true
            }
            if(isDestin){
                sb.append(tArr[i])
                sb.append(' ')
            }
        }
        sb.append('\n')

    }

    print(sb.toString())
}