import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var tok = StringTokenizer(readLine())

    var land = Array(501){IntArray(501){0} }
    val N = tok.nextToken().toInt()
    val M = tok.nextToken().toInt()
    val B = tok.nextToken().toInt()
    var maxH = B

    for(i in 1.. N){
        tok = StringTokenizer(readLine())
        for(j in 1..M){
            land[i][j] = tok.nextToken().toInt()
            maxH += land[i][j]
        }
    }

    maxH /= (N * M)
    var minwork = Integer.MAX_VALUE
    var height = 256
    for(k in maxH downTo 0){
        var temptime = 0
        for(i in 1..N){
            for(j in 1..M){
                if(land[i][j] > k){
                    temptime += (land[i][j] - k) * 2
                }
                else{
                    temptime += k - land[i][j]

                }
            }
        }

        if(temptime < minwork){
            minwork = temptime
            height = k
        }
    }
    print("$minwork $height\n")

}