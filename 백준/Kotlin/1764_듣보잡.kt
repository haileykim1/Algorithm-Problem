import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var N = 0
var M = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val tok = StringTokenizer(readLine())
    N = tok.nextToken().toInt()
    M = tok.nextToken().toInt()
    var mlist = mutableListOf<String>()
    var repeated = mutableListOf<String>()
    for(i in 1..N){
        mlist.add(readLine())
    }
    mlist.sort()
    for(i in 1..M){
        val input = readLine()
        if(mlist.binarySearch(input, 0, mlist.size) >= 0){
            repeated.add(input)
        }
    }
    repeated.sort()
    print("${repeated.size}\n")
    repeated.forEach{
        print("$it\n")
    }
}