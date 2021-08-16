import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val tok = StringTokenizer(readLine())
    val N = tok.nextToken().toInt()
    val K = tok.nextToken().toInt()
    var ans = 100000
    var queue = ArrayList<Pair<Int, Int>>()
    var cur = 0
    var dist = IntArray(100001){100001}
    dist[N] = 0
    queue.add(Pair(N, 0))
    while(cur < queue.size){
        val now = queue[cur].first
        val time = queue[cur++].second
        if(now == K)
            ans = min(ans, time)
        if(time <= dist[now]){
            if((now - 1 >= 0) && dist[now - 1] > (time + 1)){
                dist[now - 1] = time + 1
                queue.add(Pair(now - 1, time + 1))
            }
            if((now + 1 <= 100000) && (dist[now + 1] > (time + 1))){
                dist[now + 1] = time + 1
                queue.add(Pair(now + 1, time + 1))
            }
            if((now * 2 <= 100000) && (dist[now * 2] > time)){
                dist[now * 2] = time
                queue.add(Pair(now * 2, time))
            }
        }
    }
    print("$ans\n")
}