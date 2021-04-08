import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Math.pow
import java.util.*

var N = 0
var r = 0
var c = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val tok = StringTokenizer(readLine())
    N = tok.nextToken().toInt()
    r = tok.nextToken().toInt()
    c = tok.nextToken().toInt()
    var ans = 0

    for(i in N downTo 1){
        var temp =  (r / pow(2.toDouble(), (i - 1).toDouble()).toInt()) * 2 +  (c / pow(2.toDouble(), (i - 1).toDouble()).toInt())
        ans += pow(2.toDouble(), (i - 1).toDouble()).toInt() * pow(2.toDouble(), (i - 1).toDouble()).toInt() * temp

        r %= pow(2.toDouble(), (i - 1).toDouble()).toInt()
        c %= pow(2.toDouble(), (i - 1).toDouble()).toInt()

    }
    print("$ans\n")
}