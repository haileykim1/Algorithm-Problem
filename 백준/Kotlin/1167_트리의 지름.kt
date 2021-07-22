import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

var V = 0
var dist = arrayOf<ArrayList<Pair<Int, Int>>>()
var visited = booleanArrayOf()
var diameter = 0
var farNode = 0

fun DFS(x: Int, cost:Int){
    if(visited[x])
        return

    visited[x] = true

    if(diameter < cost){
        diameter = cost
        farNode = x
    }

    dist[x].forEach{
        DFS(it.first, cost + it.second)
    }

}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    V = readLine().toInt()
    dist = Array(V + 1){ ArrayList<Pair<Int, Int>>() }
    visited = BooleanArray(V + 1){false}

    for(i in 1..V){
        var tok = StringTokenizer(readLine())
        var now = tok.nextToken().toInt()
        while(true) {
            var a = tok.nextToken().toInt()
            if (a == -1)
                break
            var b = tok.nextToken().toInt()
            dist[now].add(Pair(a, b))
        }
    }
    //root : 1
    DFS(1, 0)
    for(i in 1..V)
        visited[i] = false

    diameter = 0
    DFS(farNode, 0)

    print("$diameter\n")


}