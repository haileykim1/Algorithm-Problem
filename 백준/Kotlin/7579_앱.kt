import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min
import kotlin.math.max

var N = 0
var M = 0
var m = intArrayOf()
var c = intArrayOf()
var answer = 10001
var maxM = intArrayOf()

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    val NM = readLine().split(" ")
    N = NM[0].toInt()
    M = NM[1].toInt()
    m = IntArray(N + 1)
    c = IntArray(N + 1)
    var sum = 0


    var input = readLine().split(" ")
    for(i in 1..N){
        m[i] = input[i - 1].toInt()
    }
    input = readLine().split(" ")
    for(i in 1..N){
        c[i] = input[i - 1].toInt()
        sum += c[i]
    }
    maxM = IntArray(sum + 1){0}

    for(i in 1..N){
        for(j in sum - c[i] downTo 0){
            if(maxM[j] != 0){
                maxM[j + c[i]] = max(maxM[j + c[i]], maxM[j] + m[i])
                if(maxM[j + c[i]] >= M){
                    answer = min(answer, j + c[i])
                }
            }
        }
        maxM[c[i]] = max(maxM[c[i]], m[i])
        if(m[i] >= M){
            answer = min(answer, c[i])
        }

    }

    print("$answer\n")

}