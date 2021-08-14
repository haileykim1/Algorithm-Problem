import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var N = 0
val matrix = HashMap<Long, Array<IntArray>>()

fun DividePow(x: Long): Array<IntArray>{
    if(matrix.containsKey(x))
        return matrix.get(x)!!
    lateinit var A: Array<IntArray>
    lateinit var B: Array<IntArray>
    var ret = Array(N + 1){IntArray(N + 1)}

    if(x % 2 == 0.toLong()){
        A = DividePow(x / 2)
        B = A
    }else{
        A = DividePow(x / 2)
        B = DividePow(x / 2 + 1)
    }
    for(i in 1..N){
        for(j in 1..N){
            var temp = 0
            for(k in 1..N){
                temp += A[j][k] * B[k][i]
                temp %= 1000
            }
            ret[j][i] = temp
        }
    }
    matrix.put(x, ret)
    return ret
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var tok = StringTokenizer(readLine())
    N = tok.nextToken().toInt()
    val B = tok.nextToken().toLong()

    val temp = Array(N + 1){IntArray(N + 1)}
    for(i in 1..N){
        tok = StringTokenizer(readLine())
        for(j in 1..N){
            temp[i][j] = tok.nextToken().toInt()
        }
    }
    matrix.put(1, temp)

    DividePow(B)

    val ans = matrix.get(B)!!
    for(i in 1..N){
        for(j in 1..N){
            print("${ans[i][j] % 1000} ")
        }
        print("\n")
    }

}