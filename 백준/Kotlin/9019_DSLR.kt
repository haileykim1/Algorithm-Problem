import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.pow

var T = 0

fun L(x: Int): Int{
    val last = x / 1000
    val ret = x * 10 % 10000 + last
    return ret
}

fun R(x: Int): Int{
    val first = x % 10
    val ret = x / 10 + first * 1000
    return ret
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    T = readLine().toInt()
    var sb = StringBuilder()


    repeat(T){
        val tok = StringTokenizer(readLine())
        val A = tok.nextToken().toInt()
        val B = tok.nextToken().toInt()
        var visited = BooleanArray(10000){false}

        var queue = ArrayList<Pair<String, Int>>()
        var cur = 0
        visited[A] = true
        queue.add(Pair("", A))
        var ans = ""

        while(cur < queue.size){
            val str = queue[cur].first
            val now = queue[cur++].second

            if(now == B){
                ans = str
                break
            }
            val D = (now shl 1) % 10000
            val S = (now + 9999) % 10000
            val L = L(now)
            val R = R(now)


                if(!visited[D]){
                    visited[D] = true
                    queue.add(Pair(str + "D", D))
                }
                if(!visited[S]){
                    visited[S] = true
                    queue.add(Pair(str + "S", S))
                }

                if(!visited[L]){
                    visited[L] = true
                    queue.add(Pair(str + "L", L))
                }
                if(!visited[R]){
                    visited[R] = true
                    queue.add(Pair(str + "R",R))
                }

        }
        sb.append(ans)
        sb.append("\n")

    }
    print(sb.toString())
}