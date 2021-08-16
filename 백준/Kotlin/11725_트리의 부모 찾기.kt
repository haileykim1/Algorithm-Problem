import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var N = 0
var graph = arrayOf<ArrayList<Int>>()
var parent = intArrayOf()

fun buildTree(x: Int){
    graph[x].forEach{
        if(parent[it] == -1){
            parent[it] = x
            buildTree(it)
        }
    }
}


fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    N = readLine().toInt()
    graph = Array(N + 1){ArrayList<Int>()}
    parent = IntArray(N + 1){-1}
    repeat(N - 1){
        val tok = StringTokenizer(readLine())
        val a = tok.nextToken().toInt()
        val b = tok.nextToken().toInt()
        graph[a].add(b)
        graph[b].add(a)
    }
    parent[1] = 1
    buildTree(1)

    for(i in 2..N){
        print("${parent[i]}\n")
    }
}