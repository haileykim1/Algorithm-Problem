import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var tok = StringTokenizer(readLine())
    val N = tok.nextToken().toInt()
    val M = tok.nextToken().toInt()
    val map = HashMap<String, String>()
    val sb = StringBuilder()


    for(i in 1..N){
        tok = StringTokenizer(readLine())
        map.put(tok.nextToken(), tok.nextToken())
    }
    for(i in 1..M){
        sb.append(map.get(readLine()))
        sb.append('\n')
    }
    print(sb.toString())
}