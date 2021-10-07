import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var N = 0
var ans = 0
var prev = intArrayOf()

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    N = readLine().toInt()
    var queue = ArrayList<Pair<Int, Int>>()
    var cur = 0
    prev = IntArray(N + 1){-1}
    queue.add(Pair(N, 0))

    while(cur < queue.size){
        val now = queue[cur].first
        val cost = queue[cur++].second
        if(now == 1){
            ans = cost
            break
        }
        if(now % 3 == 0 && prev[now / 3] == -1){
            queue.add(Pair(now / 3, cost + 1))
            prev[now / 3] = now
        }
        if(now % 2 == 0 && prev[now / 2] == -1){
            queue.add(Pair(now / 2, cost + 1))
            prev[now / 2] = now
        }
        if(prev[now - 1] == -1){
            queue.add(Pair(now - 1, cost + 1))
            prev[now - 1] = now
        }
    }
    print("$ans\n")
    var tracking = IntArray(ans + 1)
    var trackIter = 1
    tracking[0] = 1
    var nowCursor = 1
    while(nowCursor != N){
        tracking[trackIter++] = prev[nowCursor]
        nowCursor = prev[nowCursor]
    }
    tracking[ans] = N
    tracking.reverse()
    for(i in 0..ans)
        print("${tracking[i]} ")
    print("\n")
}