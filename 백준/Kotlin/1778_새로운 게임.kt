import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max

//17780 새로운 게임

var N = 0
var K = 0
var arr = arrayOf<IntArray>()
var exists = arrayOf<Array<ArrayList<Int>>>()

var dx = arrayOf(0, 0, 0, -1, 1)
var dy = arrayOf(0, 1, -1, 0, 0)

var locX = intArrayOf()
var locY = intArrayOf()
//0 : 올라탄 경우, 안움직이는 경우
var dir = intArrayOf()
var isBottom = booleanArrayOf()
var continueFlag = booleanArrayOf()
var level = 1


fun executeTurn(){

    for(i in 1..K){
        val nowX = locX[i]
        val nowY = locY[i]
        if(isBottom[i] && continueFlag[i]){

            var nextX = nowX + dx[dir[i]]
            var nextY = nowY + dy[dir[i]]

            //맵 벗어나는 경우 1 <->2 , 3 <-> 4
            if((nextX < 1) || (nextX > N) || (nextY < 1) || (nextY > N)){
                dir[i] = changeDir(dir[i])
                nextX = nowX + dx[dir[i]]
                nextY = nowY + dy[dir[i]]

            }

            //파란색
            if(arr[nextX][nextY] == 2){
                dir[i] = changeDir(dir[i])
                nextX = nowX + dx[dir[i]]
                nextY = nowY + dy[dir[i]]

                //진행: 파란색 or 벽
                if((nextX < 1) || (nextX > N) || (nextY < 1) || (nextY > N) || (arr[nextX][nextY] == 2)){
                    nextX = nowX
                    nextY = nowY
                    continueFlag[i] = false
                }

            }

            if(continueFlag[i]){
                //흰색
                if(arr[nextX][nextY] == 0){
                    //빈칸일 경우
                    val horses = exists[nowX][nowY]
                    val isEmpty = exists[nextX][nextY].isEmpty()
                    exists[nextX][nextY].addAll(horses)

                    if(!isEmpty){
                        isBottom[i] = false
                    }

                    exists[nowX][nowY].clear()
                    locX[i] = nextX
                    locY[i] = nextY
                }

                //빨간색
                if(arr[nextX][nextY] == 1){
                    //빈칸일 경우
                    var horses = ArrayList<Int>(exists[nowX][nowY].reversed())
                    val isEmpty = exists[nextX][nextY].isEmpty()
                    exists[nextX][nextY].addAll(horses)
                    val bottom = horses[0]
                    isBottom[i] = false

                    if(isEmpty){
                        isBottom[bottom] = true
                        locX[bottom] = nextX
                        locY[bottom] = nextY
                    }
                    exists[nowX][nowY].clear()
                }
            }
            level = max(level, exists[nextX][nextY].size)

        }
    }
}

fun changeDir(nowDir: Int): Int{
    val base: Int = nowDir / 3
    return  4 * base + 3 - nowDir
}


fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var tok = StringTokenizer(readLine())
    N = tok.nextToken().toInt()
    K = tok.nextToken().toInt()

    arr = Array(N + 1){IntArray(N + 1){0} }
    exists = Array(N + 1){Array(N + 1){ArrayList<Int>()} }
    locX = IntArray(K + 1)
    locY = IntArray(K + 1)
    dir = IntArray(K + 1)
    isBottom = BooleanArray(K + 1){true}
    continueFlag = BooleanArray(K + 1){true}

    for(i in 1..N){
        tok = StringTokenizer(readLine())
        for(j in 1..N){
            arr[i][j] = tok.nextToken().toInt()
        }
    }

    for(i in 1..K){
        tok = StringTokenizer(readLine())
        locX[i] = tok.nextToken().toInt()
        locY[i] = tok.nextToken().toInt()
        dir[i] = tok.nextToken().toInt()
        exists[locX[i]][locY[i]].add(i)
    }

    var turn = 0

    while(turn < 1000){
        ++turn
        executeTurn()


        if(level >= 4){
            break
        }
    }

    if(level >= 4){
        print("$turn\n")
    }else{
        print("-1\n")
    }

}