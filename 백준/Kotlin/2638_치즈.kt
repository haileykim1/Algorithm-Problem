import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var N = 0
var M = 0
var arr = arrayOf<IntArray>()
var left = 0
var dx = arrayOf(-1, 0, 0, 1)
var dy = arrayOf(0, -1, 1, 0)
var cheese = ArrayList<Pair<Int, Int>>()
var cheeseVisit = booleanArrayOf()
var meltList = ArrayList<Pair<Int, Int>>()

fun Melting(){
    var airQ = ArrayList<Pair<Int, Int>>()

    //find cheese to be melted
    for(i in 0..cheese.size - 1){
        if(cheeseVisit[i] == false){
            var cnt = 0
            var nx = cheese[i].first
            var ny = cheese[i].second
            for(i in 0..3){
                val nnx = nx + dx[i]
                val nny = ny + dy[i]
                if((nnx <= 0) || (nnx > N) || (nny <= 0) || (nny > M))
                    continue
                if(arr[nnx][nny] == 3)
                    ++cnt

            }
            if(cnt >= 2){
                meltList.add(Pair(nx, ny))
                airQ.add(Pair(nx, ny))
                cheeseVisit[i] = true
            }

        }
    }


    //melting cheese
    for(i in 0..meltList.size - 1){
        arr[meltList[i].first][meltList[i].second] = 3
        --left
    }

    //update outer Air
    var cur = 0
    while(cur < airQ.size){
        var nx = airQ[cur].first
        var ny = airQ[cur++].second
        if(arr[nx][ny] == 0)
            arr[nx][ny] = 3

        for(i in 0..3){
            val nnx = nx + dx[i]
            val nny = ny + dy[i]
            if((nnx <= 0) || (nnx > N) || (nny <= 0) || (nny > M))
                continue
            if(arr[nnx][nny] == 0){
                airQ.add(Pair(nnx, nny))
            }
        }
    }
}

fun OuterAirDetecting(){
    var queue = ArrayList<Pair<Int, Int>>()
    var cur = 0
    queue.add(Pair(1, 1))
    while(cur < queue.size){
        var nx = queue[cur].first
        var ny = queue[cur++].second
        if(arr[nx][ny] == 3)
            continue
        arr[nx][ny] = 3
        for(i in 0..3){
            val nnx = nx + dx[i]
            val nny = ny + dy[i]
            if((nnx <= 0) || (nnx > N) || (nny <= 0) || (nny > M))
                continue
            if(arr[nnx][nny] == 0){
                queue.add(Pair(nnx, nny))
            }
        }
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var tok = StringTokenizer(readLine())
    N = tok.nextToken().toInt()
    M = tok.nextToken().toInt()
    arr = Array(N + 1){IntArray(M + 1){0} }
    for(i in 1..N){
        tok = StringTokenizer(readLine())
        for(j in 1..M){
            arr[i][j] = tok.nextToken().toInt()
            if(arr[i][j] == 1){
                ++left
                cheese.add(Pair(i, j))
            }
        }
    }
    cheeseVisit = BooleanArray(cheese.size){false}
    OuterAirDetecting()

    var ans = 0
    while(left > 0){
        meltList.clear()
        Melting()
        ++ans
    }

    print("$ans\n")

}