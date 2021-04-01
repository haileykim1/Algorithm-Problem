import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
var N = 0
var mmap : Array<IntArray> = Array(26){IntArray(26){0} }
var visited = Array(26){BooleanArray(26){false} }
var ans = ArrayList<Int>()
var house = 0
val nx = arrayOf(-1, 0, 0, 1)
val ny = arrayOf(0, -1, 1, 0)

fun Neighborhood(x: Int, y: Int){
    ++house
    visited[x][y] = true
    for(i in 0..3){
        val nnx = x + nx[i]
        val nny = y + ny[i]
        if((nnx <= 0) || (nnx > N) || (nny <= 0) || (nny > N))
            continue
        if((mmap[nnx][nny] == 1) && (visited[nnx][nny] == false))
            Neighborhood(nnx, nny)

    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    N = readLine().toInt()
    for(i in 1.. N){
        var str = readLine()
        for(j in 1..N){
            mmap[i][j] = str[j - 1].toInt() - 48
        }
    }
    for(i in 1..N){
        for(j in 1..N){
            if((mmap[i][j] == 1) && (visited[i][j] == false)){
                house = 0
                Neighborhood(i, j)
                ans.add(house)
            }
        }
    }
    ans.sort()
    print("${ans.size}\n")
    ans.forEach{
        print("$it\n")
    }
}