import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var tok = StringTokenizer(readLine())
    val K = tok.nextToken().toInt()
    val N = tok.nextToken().toInt()
    var lines = ArrayList<Int>()

    for(i in 1..K)
        lines.add(readLine().toInt())

    var left : Long = 1.toLong()
    var right : Long = Integer.MAX_VALUE.toLong() + 1
    while(left < right){
        val mid : Long = (left + right) / 2
        var linenum : Int = 0
        lines.forEach{
            linenum += (it / mid).toInt()
        }
        if (linenum >= N)
            left = mid + 1
        else
            right = mid

    }
    println("${left - 1}\n")
}