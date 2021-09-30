import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs

var N = 0
var map = arrayOf<IntArray>()
var fish = 0
var ans = 0
var locX = 0
var locY = 0
var sharkSize = 2
var fishStack = 0
val dx = arrayOf(-1, 0, 0, 1)
val dy = arrayOf(0, -1, 1, 0)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    N = readLine().toInt()
    map = Array(N + 1){IntArray(N + 1)}

    for(i in 1..N){
        val tok = StringTokenizer(readLine())
        for(j in 1..N){
            val cell = tok.nextToken().toInt()
            if(cell > 0 && cell < 9){
                ++fish
            }
            map[i][j] = cell
            if(cell == 9){
                locX = i
                locY = j
            }
        }
    }
    while(fish > 0){
        var q = ArrayList<Pair<Int, Pair<Int, Int>>>()
        val visited = Array(N + 1){BooleanArray(N + 1){false} }
        var cur = 0
        var pq = PriorityQueue(Comparator<Pair<Int, Int>>{a, b ->
            if(a.first == b.first)
                a.second - b.second
            else
                a.first - b.first
        })
        var shortest = -1
        q.add(Pair(0, Pair(locX, locY)))
        visited[locX][locY] = true
        loop@while(cur < q.size){
            val c = q[cur].first
            val nowX = q[cur].second.first
            val nowY = q[cur++].second.second
            val isFish = map[nowX][nowY]
            if(shortest != -1 && c > shortest)
                break@loop
            if((isFish > 0) && (isFish < 9)){
                if(sharkSize > isFish){
                    if(shortest == -1){
                        shortest = c
                    }
                    if(c == shortest)
                        pq.add(Pair(nowX, nowY))

                }
                if(sharkSize < isFish)
                    continue
            }
            for(i in 0..3){
                val nx = nowX + dx[i]
                val ny = nowY + dy[i]
                if((nx <= 0) || (nx > N) || (ny <= 0) || (ny > N))
                    continue
                if(!visited[nx][ny]){
                    visited[nx][ny] = true
                    q.add(Pair(c + 1, Pair(nx, ny)))
                }
            }
        }
        if(pq.isEmpty())
            break
        val goX = pq.peek().first
        val goY = pq.peek().second
        ans += shortest
        locX = goX
        locY = goY
        map[goX][goY] = 0
        --fish
        fishStack++

        if(fishStack == sharkSize){
            sharkSize++
            fishStack = 0
        }
    }
    print("$ans\n")
}