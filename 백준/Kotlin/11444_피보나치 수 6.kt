import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var n = 0.toLong()
var matrix = HashMap<Long, Array<LongArray>>()

fun DividePow(x: Long) : Array<LongArray>{
    if(matrix.containsKey(x))
        return matrix.get(x)!!
    lateinit var A: Array<LongArray>
    lateinit var B: Array<LongArray>
    var ret = Array(3){LongArray(3){0} }
    if(x % 2 == 0.toLong()){
        A = DividePow(x / 2)
        B = A
    }else{
        A = DividePow(x / 2)
        B = DividePow(x / 2 + 1)
    }

    ret[1][1] = (A[1][1] * B[1][1] + A[1][2] * B[2][1]) % 1000000007
    ret[1][2] = (A[2][1] * B[1][1] + A[2][2] * B[2][1]) % 1000000007
    ret[2][1] = (A[1][1] * B[1][2] + A[1][2] * B[2][2]) % 1000000007
    ret[2][2] = (A[2][1] * B[1][2] + A[2][2] * B[2][2]) % 1000000007

    matrix.put(x, ret)
    return ret
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    n = readLine().toLong()
    var temp = Array(3){LongArray(3){0} }
    temp[1][1] = 1
    temp[1][2] = 1
    temp[2][1] = 1
    matrix.put(1, temp)

    DividePow(n)

    val ans = matrix.get(n)!!
    print("${ans[1][2] % 1000000007}\n")

}