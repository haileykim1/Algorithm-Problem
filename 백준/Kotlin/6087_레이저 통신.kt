import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var W = 0
var H = 0
var dx = arrayOf(-1, 0, 0, 1)
var dy = arrayOf(0, -1, 1, 0)
var arr = arrayOf<IntArray>()
var minMirror = arrayOf<IntArray>()
var cPos = ArrayList<Pair<Int, Int>>()

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val WH = readLine().split(" ")
    W = WH[0].toInt()
    H = WH[1].toInt()
    arr = Array(H){IntArray(W)}
    minMirror = Array(H){IntArray(W){10000} }

    for(i in 0..H - 1){
        val input = readLine()
        for(j in 0..W - 1){
            when(input[j]){
                '.' -> arr[i][j] = 0
                '*' -> arr[i][j] = 1
                else ->{
                    arr[i][j] = 2
                    cPos.add(Pair(i, j))
                }
            }
        }
    }

    //{{방향, 방향전환수}, {x, y}}
    var q = ArrayList<Pair<Pair<Int, Int>, Pair<Int, Int>>>()
    var qCur = 0
    val startX = cPos[0].first
    val startY = cPos[0].second
    q.add(Pair(Pair(0, 0), Pair(startX, startY)))
    q.add(Pair(Pair(1, 0), Pair(startX, startY)))
    q.add(Pair(Pair(2, 0), Pair(startX, startY)))
    q.add(Pair(Pair(3, 0), Pair(startX, startY)))
    minMirror[startX][startY] = 0

    while(qCur < q.size){
        val now = q[qCur++]
        var x = now.second.first
        var y = now.second.second
        var dir = now.first.first
        var dirChange = now.first.second
        if(dirChange <= minMirror[x][y]){
            minMirror[x][y] = dirChange
            for(i in 0..3){
                var nx = x + dx[i]
                var ny = y + dy[i]

                if((nx < 0) || (nx >= H) || (ny < 0) || (ny >= W) || (arr[nx][ny] == 1)){
                    continue
                }
                var nDirChange = dirChange
                if(dir != i){
                    ++nDirChange
                }
                if(minMirror[nx][ny] > nDirChange){
                    q.add(Pair(Pair(i, nDirChange), Pair(nx, ny)))
                }
            }

        }
    }

    print("${minMirror[cPos[1].first][cPos[1].second]}\n")

}