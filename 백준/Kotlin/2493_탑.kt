import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var N = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    N = readLine().toInt()
    val tok = StringTokenizer(readLine())
    var stack = Stack<Pair<Int, Int>>()
    var sb = StringBuilder()
    for(i in 1..N){
        var now = tok.nextToken().toInt()
        while(true){
            if(stack.isEmpty()){
                sb.append("0 ")
                break
            }
            if(stack.peek().second < now)
                stack.pop()
            else{
                sb.append(stack.peek().first)
                sb.append(" ")
                break
            }
        }

        stack.push(Pair(i, now))
    }

    print("${sb.toString()}\n")
}