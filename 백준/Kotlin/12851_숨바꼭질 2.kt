import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val tok = StringTokenizer(readLine())
    val N = tok.nextToken().toInt()
    val K = tok.nextToken().toInt()
    var cur = 0
    var queue = ArrayList<Pair<Int, Int>>()
    var found = -1
    var visited = BooleanArray(100001){false}
    var ans = 0
    queue.add(Pair(N, 0))

    while(cur < queue.size){
        val now = queue[cur].first
        val time = queue[cur++].second

        visited[now] = true

        if((found != -1) && (time == found) && (now == K))
            ++ans
        if((now == K) && (found == -1)){
            found = time
            ++ans
        }
        if((found != -1) && (time > found))
            break

        if((now - 1 >= 0) && !visited[now - 1])
            queue.add(Pair(now - 1, time + 1))

        if((now + 1 <= 100000) && !visited[now + 1])
            queue.add(Pair(now + 1, time + 1))

        if((now * 2 <= 100000) && !visited[now * 2])
            queue.add(Pair(now * 2, time + 1))

    }

    print("$found\n$ans\n")
}