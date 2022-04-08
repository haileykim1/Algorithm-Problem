import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

var N = 0
var M = 0
var K = 0
var flight = arrayOf<ArrayList<Airport>>()
var ans = 10000000
var dp = arrayOf<IntArray>()

fun Dijkstra(){
    var pq = PriorityQueue<Airport>()
    pq.offer(Airport(1, 0, 0))
    dp[1].fill(0)
    while(pq.isNotEmpty()){
        val now = pq.poll()
        if(dp[now.num][now.cost] >= now.time){
            flight[now.num].forEach{
                val next = it.num
                val nCost = now.cost + it.cost
                val nTime = now.time + it.time
                if((nCost <= M) && (dp[next][nCost] > nTime)){
                    dp[next][nCost] = nTime
                    for(i in nCost + 1..M){
                        if(dp[next][i] <= dp[next][nCost]){
                            break
                        }
                        dp[next][i] = nTime
                    }
                    pq.add(Airport(next, nCost, nTime))
                    if(next == N){
                        ans = min(ans, nTime)
                    }
                }
            }
        }
    }


}

data class Airport(val num: Int = 0, val cost: Int = 0, val time: Int = 0): Comparable<Airport>{
    override fun compareTo(other: Airport): Int {
        if(this.time == other.time){
            this.cost - other.cost
        }
        return time - other.time
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    val T = readLine().toInt()
    val sb = StringBuilder()
    repeat(T){
        ans = 10000000
        var tok = StringTokenizer(readLine())
        N = tok.nextToken().toInt()
        M = tok.nextToken().toInt()
        K = tok.nextToken().toInt()
        flight = Array(N + 1){ArrayList<Airport>()}
        dp = Array(N + 1){IntArray(M + 1){10000000} }
        for(i in 1..K){
            tok = StringTokenizer(readLine())
            flight[tok.nextToken().toInt()].add(Airport(tok.nextToken().toInt(), tok.nextToken().toInt(), tok.nextToken().toInt()))
        }

        Dijkstra()

        if(ans == 10000000){
            sb.append("Poor KCM\n")
        }else{
            sb.append(ans)
            sb.append('\n')
        }

    }
    print(sb.toString())
}