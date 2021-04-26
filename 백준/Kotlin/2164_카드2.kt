import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val N = readLine().toInt()
    var q = ArrayList<Int>()
    var cur = 0
    for(i in 1..N)
        q.add(i)
    while(cur < q.size){
        if(cur % 2 == 1){
            q.add(q[cur])
        }
        ++cur
    }
    print("${q[cur - 1]}\n")
}