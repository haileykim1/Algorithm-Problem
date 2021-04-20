import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val N = readLine().toInt()
    val tok = readLine().split(" ")
    var marr = IntArray(N)

    var mmap = HashMap<Int, Int>()

    for(i in 0..N - 1){
        marr[i] = tok[i].toInt()
    }
    var sortedArr = marr.clone()
    sortedArr.sort()
    var cnt = 0
    sortedArr.forEach{
        if(!mmap.containsKey(it))
            mmap.put(it, cnt++)
    }
    var sb = StringBuilder();
    marr.forEach {
        sb.append(mmap.get(it)).append(' ')
    }
    print("${sb.toString()}\n")
}