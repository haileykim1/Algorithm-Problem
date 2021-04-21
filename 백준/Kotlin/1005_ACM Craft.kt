import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val T = readLine().toInt()
    var time = IntArray(1001)
    var preReq = arrayOf(ArrayList<Int>())
    var ans = 0
    var built = IntArray(1001){-1}

    fun Build(x: Int): Int{
        var ret = 0
        preReq[x].forEach {
            if(built[it] != -1)
                ret = max(ret, built[it])
            else
                ret = max(ret, Build(it))
        }
        built[x] = ret + time[x]
        return built[x]
    }

    for(t in 1..T){
        var tok = StringTokenizer(readLine())
        val N = tok.nextToken().toInt()
        val K = tok.nextToken().toInt()
        preReq = Array(N + 1){ArrayList<Int>()}
        tok = StringTokenizer(readLine())
        ans = 0

        for(i in 1..N){
            built[i] = -1
            time[i] = tok.nextToken().toInt()
        }

        for(i in 1..K){
            tok = StringTokenizer(readLine())
            val X = tok.nextToken().toInt()
            val Y = tok.nextToken().toInt()
            preReq[Y].add(X)
        }
        val W = readLine().toInt()

        print("${Build(W)}\n")

    }

}