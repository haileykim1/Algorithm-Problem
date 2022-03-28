import java.io.BufferedReader
import java.io.InputStreamReader

var R = 0
var C = 0

var lake = arrayOf<IntArray>()
var swanPos = ArrayList<Pair<Int, Int>>()
val dx = arrayOf(-1, 0, 0, 1)
var dy = arrayOf(0, -1, 1, 0)
var meltQ = ArrayList<Pair<Int, Int>>()
var nextQ = ArrayList<Pair<Int, Int>>()
var visited = arrayOf<BooleanArray>()
var meetVisited = arrayOf<BooleanArray>()
var q = ArrayList<Pair<Int, Int>>()

fun Melt(){

    var qCur = 0
    while(qCur < meltQ.size){
        val nowX = meltQ[qCur].first
        val nowY = meltQ[qCur++].second
        for(i in 0..3) {
            val nextX = nowX + dx[i]
            val nextY = nowY + dy[i]
            if((nextX < 1) || (nextX > R) || (nextY < 1) || (nextY > C) || (lake[nextX][nextY] != 1)){
                continue
            }
            if(!visited[nextX][nextY]){
                nextQ.add(Pair(nextX, nextY))
                visited[nextX][nextY] = true
            }

        }
    }
    qCur = 0
    while(qCur < nextQ.size){
        val x = nextQ[qCur].first
        val y = nextQ[qCur++].second
        lake[x][y] = 0
    }

    meltQ = nextQ.clone() as ArrayList<Pair<Int, Int>>
    nextQ.clear()
}

fun canMeet(): Boolean{
    var ret = false
    var qCur = 0
    //0 -> 1
    var nQ = ArrayList<Pair<Int, Int>>()
    while(qCur < q.size){
        val nowX = q[qCur].first
        val nowY = q[qCur++].second
        meetVisited[nowX][nowY] = true
        if((nowX == swanPos[1].first) && (nowY == swanPos[1].second)) {
            ret = true
            break
        }
        var cnt = 0
        for(i in 0..3){
            val nextX = nowX + dx[i]
            val nextY = nowY + dy[i]
            if((nextX < 1) || (nextX > R) || (nextY < 1) || (nextY > C) || meetVisited[nextX][nextY] || (lake[nextX][nextY] == 1)){
                continue
            }
            q.add(Pair(nextX, nextY))
            meetVisited[nextX][nextY] = true
            ++cnt
        }
        if(cnt == 0){
            nQ.add(Pair(nowX, nowY))
        }

    }
    q.clear()
    q = nQ
    return ret
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    val rc = readLine().split(" ")
    R = rc[0].toInt()
    C = rc[1].toInt()

    lake = Array(R + 1){IntArray(C + 1)}
    visited = Array(R + 1){BooleanArray(C + 1){false} }
    meetVisited = Array(R + 1){BooleanArray(C + 1){false} }

    for(i in 1..R){
        val input = readLine()
        for(j in 0..C - 1){
            if(input[j] == '.'){
                lake[i][j + 1] = 0
                meltQ.add(Pair(i, j + 1))
            }else if(input[j] == 'X'){
                lake[i][j + 1] = 1
            }else{
                lake[i][j + 1] = 2
                swanPos.add(Pair(i, j + 1))
                meltQ.add(Pair(i, j + 1))
            }
        }
    }

    var ans = 0
    q.add(Pair(swanPos[0].first, swanPos[0].second))

    while(true){
        if(canMeet()){
            break
        }
        for(i in 1..R){
            visited[i].fill(false)
        }
        Melt()
        ++ans
    }

    print("$ans\n")

}