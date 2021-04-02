import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val N = readLine().toInt()
    var q = ArrayList<Int>()
    for(i in 1..N){
        var tok = StringTokenizer(readLine())
        val command = tok.nextToken()
        when(command){
            "push" -> q.add(tok.nextToken().toInt())
            "pop" -> {
                if(q.isEmpty())
                    print("-1\n")
                else{
                    print("${q[0]}\n")
                    q.removeAt(0)
                }
            }
            "size" -> print("${q.size}\n")
            "empty" -> {
                if(q.isEmpty())
                    print("1\n")
                else
                    print("0\n")
            }
            "front" -> {
                if(q.isEmpty())
                    print("-1\n")
                else
                    print("${q[0]}\n")
            }
            "back" -> {
                if(q.isEmpty())
                    print("-1\n")
                else
                    print("${q.last()}\n")
            }
        }
    }
}