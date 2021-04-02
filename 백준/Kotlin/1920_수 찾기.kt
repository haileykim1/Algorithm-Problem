import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val N = readLine().toInt()
    var A = HashSet<Int>()
    var tok = StringTokenizer(readLine())
    for(i in 1..N){
        A.add(tok.nextToken().toInt())
    }

    var B = ArrayList<Int>()
    val M = readLine().toInt()
    tok = StringTokenizer(readLine())
    for(i in 1..M){
        B.add(tok.nextToken().toInt())
    }

    for(i in 0..M - 1){
        if(A.contains(B[i]))
            print("1\n")
        else
            print("0\n")
    }

}