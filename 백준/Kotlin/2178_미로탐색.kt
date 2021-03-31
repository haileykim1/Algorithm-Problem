import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var N = 0
var M = 0
var arr1 = Array(101){IntArray(101){0} }
var ans = Array(101){IntArray(101){10001} }
val nx = arrayOf(-1, 0, 0, 1)
val ny = arrayOf(0, -1, 1, 0)

fun Go(x: Int, y: Int, n: Int){
    ans[x][y] = n
    for(i in 0..3){
        val nnx = x + nx[i]
        val nny = y + ny[i]
        if((nnx <= 0) || (nnx > N) || (nny <= 0) || (nny > M))
            continue
        if((ans[nnx][nny] > n + 1) && (arr1[nnx][nny] == 1))
            Go(nnx, nny, n + 1)

    }


}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var tok = StringTokenizer(readLine())
    N = tok.nextToken().toInt()
    M = tok.nextToken().toInt()

    for(i in 1..N){
        val str = readLine()
        for(j in 1..M){
            arr1[i][j] = str[j - 1].toInt() - 48
        }
    }

    Go(1, 1, 1)

    print("${ans[N][M]}\n")
}