import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min
import kotlin.math.max

var N = 0
var M = 0
var arr = intArrayOf()

fun BinarySearch(x: Int): Int{
    var ret = 1
    var mini = arr[0]
    var maxi = arr[0]
    for(i in 0..N - 1){
        val now = arr[i]
        mini = min(mini, now)
        maxi = max(maxi, now)
        if(maxi - mini > x){
            ++ret
            mini = now
            maxi = now
        }
    }
    return ret
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var tok = StringTokenizer(readLine())
    N = tok.nextToken().toInt()
    M = tok.nextToken().toInt()
    tok = StringTokenizer(readLine())
    arr = IntArray(N)
    var right = 0
    for(i in 0..N - 1){
        arr[i] = tok.nextToken().toInt()
        right = max(right, arr[i])
    }

    var left = 0
    var mid = (left + right) shr 1

    while(left < right){
        var cnt = BinarySearch(mid)
        if(cnt > M)
            left = mid + 1
        else
            right = mid
        mid = (left + right) shr 1
    }
    print("$mid\n")

}