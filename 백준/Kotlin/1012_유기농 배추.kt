import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val mmap = Array(51){BooleanArray(51){false} }
val visited = Array(51){BooleanArray(51){false} }

var M = 0
var N = 0
var K = 0
var ans = 0
val nx = arrayOf(0, -1, 1, 0)
val ny = arrayOf(-1, 0, 0, 1)

fun Neighbor(x:Int, y: Int){
    visited[x][y] = true
    for(i in 0..3){
        val nnx = x + nx[i]
        val nny = y + ny[i]
        if((nnx < 0) || (nnx >= M) || (nny < 0) || (nny >= N)){
            continue
        }
        if((mmap[nnx][nny] == true) && (visited[nnx][nny] == false))
            Neighbor(nnx, nny)
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val T = readLine().toInt()
    for(t in 1..T){
        for(i in 0..50){
            for(j in 0..50){
                mmap[i][j] = false
                visited[i][j] = false
            }
        }

        ans = 0
        var tok = StringTokenizer(readLine())
        M = tok.nextToken().toInt()
        N = tok.nextToken().toInt()
        K = tok.nextToken().toInt()

        for (i in 1..K){
            tok = StringTokenizer(readLine())
            mmap[tok.nextToken().toInt()][tok.nextToken().toInt()] = true
        }

        for(i in 0..M - 1){
            for(j in 0..N - 1){
                if((mmap[i][j] == true) && (visited[i][j] == false)){
                    Neighbor(i, j)
                    ++ans
                }
            }
        }
        print("$ans\n")

    }

}