import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var N = 0
var star = arrayOf<CharArray>()

fun BuildStar(x: Int, y: Int, s: Int){
    if(s == 3){
        star[x][y] = '*'
        star[x + 1][y - 1] = '*'
        star[x + 1][y + 1] = '*'
        for(i in -2..2)
            star[x + 2][y + i] = '*'
        return
    }
    BuildStar(x, y, s / 2)
    BuildStar(x + s / 2, y - s / 2, s / 2)
    BuildStar(x + s / 2, y + s / 2, s / 2)
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    N = readLine().toInt()
    star = Array(N + 1){CharArray(2 * N + 1 ){' '} }

    BuildStar(1, N, N)

    var ans = StringBuilder()
    for(i in 1..N){
        for(j in 1..2 * N - 1){
            ans.append(star[i][j])
        }
        ans.append('\n')
    }
    print(ans.toString())
}