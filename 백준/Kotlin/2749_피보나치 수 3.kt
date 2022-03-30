import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger
import java.util.*

val DIV = 1000000

val matrix = arrayOf(arrayOf(0, 1), arrayOf(1, 1))
var n = 0.toLong()
var map = HashMap<Long, Array<Array<Int>>>()

fun exp(x: Long): Array<Array<Int>>{

    if(map.containsKey(x)){
        return map[x]!!
    }

    if((x % 2) == 0.toLong()){
        var A = exp(x / 2)
        val n00 = ((A[0][0].toLong() * A[0][0] % DIV + A[0][1].toLong() * A[1][0] % DIV) % DIV).toInt()
        val n01 = ((A[0][0].toLong() * A[0][1] % DIV + A[0][1].toLong() * A[1][1] % DIV) % DIV).toInt()
        val n10 = ((A[1][0].toLong() * A[0][0] % DIV + A[1][1].toLong() * A[1][0] % DIV) % DIV).toInt()
        val n11 = ((A[1][0].toLong() * A[0][1] % DIV + A[1][1].toLong() * A[1][1] % DIV) % DIV).toInt()
        map.put(x, arrayOf(arrayOf(n00, n01), arrayOf(n10, n11)))
        return arrayOf(arrayOf(n00, n01), arrayOf(n10, n11))

    }else{
        var A = exp((x - 1) / 2)
        val B = exp((x - 1) / 2 + 1)
        val n00 = ((A[0][0].toLong() * B[0][0] % DIV + A[0][1].toLong() * B[1][0] % DIV) % DIV).toInt()
        val n01 = ((A[0][0].toLong() * B[0][1] % DIV + A[0][1].toLong() * B[1][1] % DIV) % DIV).toInt()
        val n10 = ((A[1][0].toLong() * B[0][0] % DIV + A[1][1].toLong() * B[1][0] % DIV) % DIV).toInt()
        val n11 = ((A[1][0].toLong() * B[0][1] % DIV + A[1][1].toLong() * B[1][1] % DIV) % DIV).toInt()
        map.put(x, arrayOf(arrayOf(n00, n01), arrayOf(n10, n11)))
        return arrayOf(arrayOf(n00, n01), arrayOf(n10, n11))
    }

}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    n = readLine().toLong()
    map.put(0, arrayOf(arrayOf(1, 0), arrayOf(0, 1)))
    map.put(1, matrix)
    if(n == 0.toLong()){
        print("0\n")
        return
    }
    val nExp = exp(n - 1)
    val ans = nExp[1][1]
    print("$ans\n")
}