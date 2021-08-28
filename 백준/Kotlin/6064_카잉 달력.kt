/*import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var T = 0
var sb = StringBuilder()

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    T = readLine().toInt()
    repeat(T){
        val tok = StringTokenizer(readLine())
        val M = tok.nextToken().toInt()
        val N = tok.nextToken().toInt()
        val x = tok.nextToken().toInt()
        val y = tok.nextToken().toInt()
        var ans = 0


        var iter = 0
        while(true){
            val k = iter * M + x
            //println("$k ${(k - y) % N}")
            if((k >= y) && ((k - y) % N == 0)){
                ans = k
                break
            }
            ++iter

            if(iter > 40000){
                ans = -1
                break
            }
        }
        sb.append(ans)
        sb.append("\n")


    }

    print(sb.toString())
}*/