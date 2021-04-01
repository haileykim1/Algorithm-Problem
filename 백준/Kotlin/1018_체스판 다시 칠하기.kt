import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

var mmap = Array(51){BooleanArray(51){false} }
var N = 0
var M = 0
var ans = 65
var isWhite = arrayOf(false, true)

fun Chess(x: Int, y: Int): Int{
    var ret = 0

    //왼쪽 위 Black 가정.
    for(i in 0..7){
        for(j in 0..7){
            if(mmap[x + i][y + j] != isWhite[(i + j) % 2])
                ++ret
        }
    }

    return min(ret, 64 - ret)
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var tok = StringTokenizer(readLine())
    N = tok.nextToken().toInt()
    M = tok.nextToken().toInt()
    for(i in 1..N){
        var str = readLine()
        for(j in 1..M){
            if(str[j - 1] == 'B')
                mmap[i][j] = false
            else
                mmap[i][j] = true
        }
    }
    for(i in 1..N - 7){
        for(j in 1..M - 7){
            ans = min(ans, Chess(i, j))
        }
    }

    print("$ans\n")
}