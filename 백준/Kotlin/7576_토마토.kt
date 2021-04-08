import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var tok = StringTokenizer(readLine())
    var tomato = Array(1001){IntArray(1001){0} }
    var left = 0
    val nx = arrayOf(0, -1, 1, 0)
    val ny = arrayOf(-1, 0, 0, 1)
    var queue = ArrayList<Pair<Int, Int>>()
    var ans = 0
    var qs = 0
    var qe = 0

    val M = tok.nextToken().toInt()
    val N = tok.nextToken().toInt()
    left = M * N

    for(i in 1..N){
        tok = StringTokenizer(readLine())
        for(j in 1..M){
            val input = tok.nextToken().toInt()
            tomato[i][j] = input
            if(input == 1){
                queue.add(Pair(i, j))
                ++qe
                --left
            }else if(input == -1)
                --left
        }
    }
    while(left > 0){
        ++ans
        while(qs < qe){
            var first = queue[qs].first
            var second = queue[qs].second
            for(i in 0..3){
                val nnx = first + nx[i]
                val nny = second + ny[i]
                if((nnx <= 0) || (nnx > N) || (nny <= 0) || (nny > M))
                    continue
                if((tomato[nnx][nny] == 0)){
                    queue.add(Pair(nnx, nny))
                    tomato[nnx][nny] = 1
                    --left
                }
            }
            ++qs
        }
        if(qe == queue.size){
            print("${-1}\n")
            return
        }
        qe = queue.size
    }
    print("$ans\n")

}