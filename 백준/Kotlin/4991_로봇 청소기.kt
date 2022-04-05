import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

var w = 0
var h = 0
var arr = arrayOf<IntArray>()
var dirtyCnt = 0
var dx = arrayOf(-1, 0, 0, 1)
var dy = arrayOf(0, -1, 1, 0)
var dirtyPos = ArrayList<Pair<Int, Int>>()
var dist = arrayOf<IntArray>()
var visited = booleanArrayOf()
var root = 0
var moved = 800
var blocked = false

fun getDist(x: Int, y: Int){
    var q = ArrayList<Pair<Int, Pair<Int, Int>>>()
    var qCur = 0
    var visited = Array(h){BooleanArray(w){false} }
    q.add(Pair(0, Pair(dirtyPos[x].first, dirtyPos[x].second)))
    var ret = 400

    while(qCur < q.size){
        val cnt = q[qCur].first
        val nowX = q[qCur].second.first
        val nowY = q[qCur++].second.second

        if((nowX == dirtyPos[y].first) && (nowY == dirtyPos[y].second)){
            ret = cnt
            break
        }
        for(i in 0..3){
            val nx = nowX + dx[i]
            val ny = nowY + dy[i]
            if((nx < 0) || (nx >= h) || (ny < 0) || (ny >= w) || (arr[nx][ny] == 2) || (visited[nx][ny])){
                continue
            }
            q.add(Pair(cnt + 1, Pair(nx, ny)))
            visited[nx][ny] = true
        }

    }
    dist[x][y] = ret
    dist[y][x] = ret
    if(ret == 400){
        blocked = true
    }
}

fun robot(x: Int, distance: Int, cnt : Int){
    for(i in 0..dirtyCnt - 1) {
        if(!visited[i]) {
            visited[i] = true
            robot(i, distance + dist[x][i], cnt + 1)
            visited[i] = false
        }
    }

    if(cnt == dirtyPos.size - 1){
        moved = min(moved, distance)
        return
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val sb = StringBuilder()
    while(true){
        moved = 800
        dirtyCnt = 0
        dirtyPos.clear()
        blocked = false
        val wh = readLine().split(" ")
        w = wh[0].toInt()
        h = wh[1].toInt()
        arr = Array(h){IntArray(w)}
        if((w == 0) && (h == 0)){
            break
        }
        for(i in 0..h - 1){
            val input = readLine()
            for(j in 0..w - 1){
                when(input[j]){
                    '.' -> arr[i][j] = 0
                    '*' ->{
                        arr[i][j] = 1
                        dirtyPos.add(Pair(i, j))
                        ++dirtyCnt
                    }
                    'x' -> arr[i][j] = 2
                    else ->{
                        dirtyPos.add(Pair(i, j))
                        root = dirtyCnt
                        arr[i][j] = 0
                        ++dirtyCnt
                    }
                }
            }
        }
        dist = Array(dirtyCnt){IntArray(dirtyCnt){400} }
        visited = BooleanArray(dirtyCnt){false}
        for(i in 0..dirtyCnt - 1){
            dist[i][i] = 0
        }
        for(i in 0..dirtyCnt - 2){
            for(j in i + 1..dirtyCnt - 1){
                getDist(i, j)
            }
        }
        if(blocked){
            sb.append("-1\n")
        }else{
            visited[root] = true
            robot(root, 0, 0)
            sb.append(moved)
            sb.append("\n")
        }
    }
    print(sb.toString())
}