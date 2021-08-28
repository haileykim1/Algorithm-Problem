import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val T = readLine().toInt()
    var sb = StringBuilder()
    repeat(T){
        val n = readLine().toInt()
        val map = HashMap<String, Int>()
        for(i in 1..n){
            val tok = StringTokenizer(readLine())
            tok.nextToken()
            val input = tok.nextToken()
            if(!map.containsKey(input)){
                map.put(input, 1)
            }else{
                map.put(input, map.get(input)!! + 1)
            }
        }
        var ans = 1
        map.values.forEach{
            ans *= (it + 1)
        }
        sb.append(ans - 1)
        sb.append("\n")
    }
    print(sb.toString())
}