import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger
import java.util.*

var result = Array(101){Array<BigInteger>(101){-1.toBigInteger()} }

fun Combination(N: Int, M: Int): BigInteger{
    if((M == 0) || (N == M))
        return 1.toBigInteger()
    if(result[N][M] != -1.toBigInteger())
        return result[N][M]

    result[N][M] = Combination(N - 1, M - 1) + Combination(N - 1, M)
    return result[N][M]
}


fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val tok = StringTokenizer(readLine())
    val n = tok.nextToken().toInt()
    val m = tok.nextToken().toInt()

    print("${Combination(n, m)}\n")

}