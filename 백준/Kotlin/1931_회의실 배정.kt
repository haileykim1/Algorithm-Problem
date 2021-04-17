import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val N = readLine().toInt()
    var ans = 0
    var pq = ArrayList<Pair<Int, Int>>()

    for(i in 1..N){
        val tok = StringTokenizer(readLine())
        pq.add(Pair(tok.nextToken().toInt(), tok.nextToken().toInt()))
    }
    pq.sortWith(Comparator{ o1, o2 ->
        when(o1.second != o2.second){
            true -> o1.second - o2.second
            false -> o1.first - o2.first
        }
    })
    var reservation = 0
    while(pq.isNotEmpty()){
        ++ans
        reservation = pq[0].second
        pq.removeAt(0)
        while((pq.isNotEmpty()) && (pq[0].first < reservation)){
            if(pq[0].first == pq[0].second)
                ++ans
            pq.removeAt(0)
        }
    }

    print("$ans\n")
}