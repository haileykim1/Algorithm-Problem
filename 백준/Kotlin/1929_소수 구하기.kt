import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var mmap = BooleanArray(1000001){true}

    mmap[1] = false

    for(i in 2..1000000){
        if(mmap[i] == true){
            var j = 2
            while(i * j <= 1000000){
                mmap[i * j] = false
                ++j
            }
        }
    }
    var tok = StringTokenizer(readLine())
    val M = tok.nextToken().toInt()
    val N = tok.nextToken().toInt()
    for(i in M..N){
        if(mmap[i] == true)
            print("$i\n")
    }
}