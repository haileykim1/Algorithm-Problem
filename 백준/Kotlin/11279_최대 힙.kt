import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val pq = PriorityQueue<Int>(Comparator{ o1, o2 -> o2 - o1})
    val N = readLine().toInt()
    for(i in 1..N){
        val input = readLine().toInt()
        if(input == 0){
            if(pq.isEmpty())
                print("0\n")
            else{
                print("${pq.poll()}\n")
            }
        }else{
            pq.add(input)
        }
    }

}