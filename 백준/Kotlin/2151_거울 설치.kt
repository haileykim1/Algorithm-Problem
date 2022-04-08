import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

var N = 0
var arr = arrayOf<IntArray>()
var door = Array(2){IntArray(2)}
val dx = arrayOf(-1, 0, 0, 1)
val dy = arrayOf(0, -1, 1, 0)
var minChange = arrayOf<Array<IntArray>>()

data class position(val x: Int = 0, val y: Int = 0, val direction: Int = 0,val dirChange: Int = 0): Comparable<position>{
    override fun compareTo(other: position): Int {
        return this.dirChange - other.dirChange
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    N = readLine().toInt()
    arr = Array(N){IntArray(N)}
    minChange = Array(N){Array(N){IntArray(4){2500} }}
    var doorCnt = 0

    for(i in 0..N - 1){
        val input = readLine()
        for(j in 0..N - 1){
            when(input[j]){
                '#' ->{
                    arr[i][j] = 0
                    door[doorCnt][0] = i
                    door[doorCnt][1] = j
                    ++doorCnt
                }
                '.' -> arr[i][j] = 0
                '*' -> arr[i][j] = 2
                '!' -> arr[i][j] = 1
            }
        }
    }

    var q = ArrayList<position>()
    var qCur = 0
    q.add(position(door[0][0], door[0][1], 0, 0))
    q.add(position(door[0][0], door[0][1], 1, 0))
    q.add(position(door[0][0], door[0][1], 2, 0))
    q.add(position(door[0][0], door[0][1], 3, 0))
    minChange[door[0][0]][door[0][1]][0] = 0
    minChange[door[0][0]][door[0][1]][1] = 0
    minChange[door[0][0]][door[0][1]][2] = 0
    minChange[door[0][0]][door[0][1]][3] = 0



    while(qCur < q.size){
        val now = q[qCur++]
        if(now.dirChange <= minChange[now.x][now.y][now.direction]){
            if(arr[now.x][now.y] == 1){
                for(i in 0..3){
                    val nx = now.x + dx[i]
                    val ny = now.y + dy[i]
                    if((nx < 0) || (nx >= N) || (ny < 0) || (ny >= N) || (arr[nx][ny] > 1)){
                        continue
                    }
                    var nDirChange = now.dirChange
                    if(now.direction != i){
                        ++nDirChange
                    }
                    if(minChange[nx][ny][i] >= nDirChange){
                        minChange[nx][ny][i] = nDirChange
                        if(arr[nx][ny] == 1){
                            for(j in 0..3){
                                minChange[nx][ny][j] = nDirChange
                            }
                        }
                        q.add(position(nx, ny, i, nDirChange))
                    }
                }
            }else{
                val nx = now.x + dx[now.direction]
                val ny = now.y + dy[now.direction]
                if((nx >= 0) && (nx < N) && (ny >= 0) && (ny < N) && (arr[nx][ny] <= 1)){
                    if(minChange[nx][ny][now.direction] > now.dirChange){
                        minChange[nx][ny][now.direction] = now.dirChange
                        if(arr[nx][ny] == 1){
                            for(j in 0..3){
                                minChange[nx][ny][j] = now.dirChange
                            }
                        }
                        q.add(position(nx, ny, now.direction, now.dirChange))
                    }
                }
            }

        }

    }
    var ans = 2500
    for(i in 0..3){
        ans = min(ans, minChange[door[1][0]][door[1][1]][i])
    }
    print("$ans\n")
}