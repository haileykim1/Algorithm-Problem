import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val N = readLine().toInt()
    var mlist = ArrayList<String>()
    for(i in 1..N){
        mlist.add(readLine())
    }
    mlist = ArrayList<String>(HashSet<String>(mlist))
    mlist.sort()
    mlist.sortWith(Comparator{data1, data2 -> data1.length - data2.length})
    mlist.forEach{
        print("$it\n")
    }
}