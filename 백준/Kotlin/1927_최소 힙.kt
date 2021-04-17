import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var pq = PriorityQueue<Int>()
    val N = readLine().toInt()

    for(i in 1..N){
        val input = readLine().toInt()
        if(input == 0){
            if(pq.isEmpty())
                print("0\n")
            else{
                print("${pq.remove()}\n")
            }
        }else{
            pq.add(input)
        }
    }
}