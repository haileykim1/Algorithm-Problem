import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var N = 0
var M = 0
var graph = Array(1001){ArrayList<Int>()}
var visited = BooleanArray(1001){false}
var ans = 0

fun CheckConnected(x:Int){
    visited[x] = true
    graph[x].forEach{
        if(visited[it] == false)
            CheckConnected(it)
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var tok = StringTokenizer(readLine())
    N = tok.nextToken().toInt()
    M = tok.nextToken().toInt()

    for(i in 1..M){
        tok = StringTokenizer(readLine())
        val a = tok.nextToken().toInt()
        val b = tok.nextToken().toInt()
        graph[a].add(b)
        graph[b].add(a)
    }

    for(i in 1..N){
        if(visited[i] == false){
            CheckConnected(i)
            ++ans
        }
    }
    print("$ans\n")
}