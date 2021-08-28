import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var M = 0
var N = 0
var H = 0
var arr = arrayOf<Array<IntArray>>()
var left = 0
var ans = 0
var dx = arrayOf(-1, 1, 0, 0, 0, 0)
var dy = arrayOf(0, 0, -1, 1, 0, 0)
var dz = arrayOf(0, 0, 0, 0, -1, 1)
var nq = ArrayList<Pair<Int, Pair<Int, Int>>>()
var impossible = false

fun Ripening(){

    var queue = ArrayList<Pair<Int,Pair<Int, Int>>>()
    //익을거 선별
    for(i in 0..nq.size - 1){
        val nowz = nq[i].first
        val nowx = nq[i].second.first
        val nowy = nq[i].second.second
        for(j in 0..5){
            val nz = nowz + dz[j]
            val nx = nowx + dx[j]
            val ny = nowy + dy[j]
            if((nz <= 0) || (nz >H) || (nx <= 0) || (nx > N) || (ny <= 0) || (ny > M))
                continue
            if(arr[nz][nx][ny] == 0){
                arr[nz][nx][ny] = 3
                queue.add(Pair(nz, Pair(nx, ny)))
            }
        }
    }
    nq.clear()
    if(queue.isEmpty())
        impossible = true
    //익는중
    queue.forEach{
        arr[it.first][it.second.first][it.second.second] = 1
        --left
        nq.add(Pair(it.first, Pair(it.second.first, it.second.second)))
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var tok = StringTokenizer(readLine())
    M = tok.nextToken().toInt()
    N = tok.nextToken().toInt()
    H = tok.nextToken().toInt()
    arr = Array(H + 1){Array(N + 1){IntArray(M + 1)} }

    for(i in 1..H){
        for(j in 1..N){
            tok = StringTokenizer(readLine())
            for(k in 1..M){
                val input = tok.nextToken().toInt()
                arr[i][j][k] = input
                if(input == 0)
                    ++left
                if(input == 1)
                    nq.add(Pair(i, Pair(j, k)))
            }
        }
    }

    while(left > 0){
        Ripening()
        ++ans
        if(impossible){
            ans = -1
            break
        }
    }

    print("$ans\n")
}