import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var n = 0
var edge = arrayOf<ArrayList<Pair<Int, Int>>>()
var dist = intArrayOf()
var visited = booleanArrayOf()

fun dfs(x: Int){
    visited[x] = true

    edge[x].forEach{
        if(!visited[it.first]){
            dist[it.first] = dist[x] + it.second
            dfs(it.first)
        }
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    n = readLine().toInt()
    edge = Array(n + 1){ArrayList<Pair<Int, Int>>()}
    repeat(n - 1){
        val tok = StringTokenizer(readLine())
        val a = tok.nextToken().toInt()
        val b = tok.nextToken().toInt()
        val c = tok.nextToken().toInt()
        edge[a].add(Pair(b, c))
        edge[b].add(Pair(a, c))
    }

    dist = IntArray(n + 1){1000000}
    visited = BooleanArray(n + 1){false}
    dist[1] = 0
    dfs(1)

    var maxIndex = 1
    var maxVal = 0
    for(i in 2..n){
        if(dist[i] > maxVal){
            maxVal = dist[i]
            maxIndex = i
        }
    }
    dist.fill(1000000)
    visited.fill(false)
    dist[maxIndex] = 0
    dfs(maxIndex)

    maxVal = 0
    for(i in 1..n){
        if(dist[i] > maxVal)
            maxVal = dist[i]
    }
    print("$maxVal\n")
}