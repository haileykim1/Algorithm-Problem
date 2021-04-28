import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val N = readLine().toInt()
    val marr = IntArray(N)
    val tok = StringTokenizer(readLine())
    for(i in 0..N - 1){
        marr[i] = tok.nextToken().toInt()
    }
    marr.sort()
    var ans = 0
    for(i in 0..N - 1){
        ans += marr[i] * (N - i)
    }
    print("$ans\n")
}