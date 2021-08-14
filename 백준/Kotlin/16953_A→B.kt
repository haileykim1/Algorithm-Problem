import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val tok = StringTokenizer(readLine())
    val A = tok.nextToken().toInt()
    val B = tok.nextToken().toInt()

    if(A > B){
        print("-1\n")
        return
    }
    if(A == B){
        print("1\n")
        return
    }

    var cur = 0
    var queue = ArrayList<Pair<Int, Int>>()
    var ans = -2

    queue.add(Pair(A, 0))
    while(cur < queue.size){
        val now = queue[cur].first
        val time = queue[cur++].second
        if(now == B){
            ans = time
            break
        }
        if((now * 2 <= B))
            queue.add(Pair(now * 2, time + 1))
        if((now * 10.toLong() + 1) <= B)
            queue.add(Pair(now * 10 + 1, time + 1))

    }
    print("${++ans}\n")

}