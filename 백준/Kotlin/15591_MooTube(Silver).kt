import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

var N = 0
var Q = 0
var R = arrayOf<ArrayList<Pair<Int, Int>>>()
var ans = 0
var k = 0
var visited = booleanArrayOf()

fun Search(x: Int, usado: Int){
    if(usado < k)
        return
    visited[x] = true
    ++ans
    R[x].forEach{
        val next = it.first
        val edge = it.second
        if(!visited[next]){
            Search(next, min(usado, edge))
        }
    }

}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var tok = StringTokenizer(readLine())
    N = tok.nextToken().toInt()
    Q = tok.nextToken().toInt()
    R = Array(N + 1){ArrayList<Pair<Int, Int>>()}
    visited = BooleanArray(N + 1){false}
    repeat(N - 1){
        tok = StringTokenizer(readLine())
        var p = tok.nextToken().toInt()
        var q = tok.nextToken().toInt()
        var r = tok.nextToken().toInt()
        R[p].add(Pair(q, r))
        R[q].add(Pair(p, r))
    }

    var sb = StringBuilder()
    repeat(Q){
        tok = StringTokenizer(readLine())
        k = tok.nextToken().toInt()
        val v = tok.nextToken().toInt()
        ans = 0
        visited.fill(false)
        Search(v, Integer.MAX_VALUE)
        sb.append(ans - 1)
        sb.append("\n")

    }
    print(sb.toString())

}