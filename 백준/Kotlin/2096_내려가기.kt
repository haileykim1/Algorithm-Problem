import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min
import kotlin.math.max

var N = 0
var scores = arrayOf<IntArray>()
var highDP = IntArray(3){0}
var lowDP = IntArray(3){0}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    N = readLine().toInt()
    scores = Array(N + 1){IntArray(3)}
    for(i in 1..N){
        val tok = StringTokenizer(readLine())
        for(j in 0..2)
            scores[i][j] = tok.nextToken().toInt()
    }

    for(i in 1..N){
        var zero = max(highDP[0], highDP[1]) + scores[i][0]
        var one = max(max(highDP[0], highDP[1]), highDP[2]) + scores[i][1]
        var two = max(highDP[1], highDP[2]) + scores[i][2]

        highDP[0] = zero
        highDP[1] = one
        highDP[2] = two


        zero = min(lowDP[0], lowDP[1]) + scores[i][0]
        one = min(min(lowDP[0], lowDP[1]), lowDP[2]) + scores[i][1]
        two = min(lowDP[1], lowDP[2]) + scores[i][2]

        lowDP[0] = zero
        lowDP[1] = one
        lowDP[2] = two
    }

    var ans = max(max(highDP[0], highDP[1]), highDP[2]).toString() + " "
    ans += min(min(lowDP[0], lowDP[1]), lowDP[2]).toString()

    print("$ans\n")


}