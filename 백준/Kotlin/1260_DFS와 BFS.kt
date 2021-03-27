import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var arr1 : Array<ArrayList<Int>> = arrayOf()
var q = arrayListOf<Int>()
var visited = booleanArrayOf()

fun DFS(X:Int){

    if(visited[X] == false){
        visited[X] = true
        print("$X ")
        arr1[X].forEach{
            if(visited[it] == false)
                DFS(it)
        }
    }

}

fun BFS(X: Int){
    q.add(X)

    while(q.isNotEmpty()){
        val a = q[0]
        print("$a ")
        visited[a] = true
        arr1[a].forEach{
            if(visited[it] == false){
                q.add(it)
                visited[it] = true
            }
        }

        q.removeAt(0)
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var tok = StringTokenizer(readLine())
    val N = tok.nextToken().toInt()
    val M = tok.nextToken().toInt()
    val V = tok.nextToken().toInt()

    arr1 = Array(N + 1){ ArrayList<Int>()}
    visited = BooleanArray(N + 1) {false}

    for(i in 1..M){
        tok = StringTokenizer(readLine())
        val a = tok.nextToken().toInt()
        val b = tok.nextToken().toInt()
        arr1[a].add(b)
        arr1[b].add(a)
    }
    for(i in 1..N){
        arr1[i].sort()
    }

    DFS(V)
    print('\n')
    for(i in 1..N){
        visited[i] = false
    }
    BFS(V)
    print('\n')
}