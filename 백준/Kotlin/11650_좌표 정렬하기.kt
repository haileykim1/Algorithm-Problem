import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.Buffer
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var mlist = ArrayList<Pair<Int, Int>>()
    val N = readLine().toInt()
    for(i in 1..N){
        val tok = StringTokenizer(readLine())
        val one = tok.nextToken().toInt()
        val two = tok.nextToken().toInt()

        mlist.add(Pair(one, two))
    }
    mlist.sortWith(Comparator { o1, o2 ->
        when(o1.first != o2.first){
            true -> o1.first - o2.first
            false -> o1.second - o2.second
        }
    })
    mlist.forEach{
        print("${it.first } ${it.second}\n")
    }
}