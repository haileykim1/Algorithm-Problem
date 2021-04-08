import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var facZero = IntArray(501){0}
    //+ : 2, - : 5
    var tenStack = 0

    for(i in 1..500){
        var plusTen = 0
        var now = i
        while(now % 2 == 0){
            if(tenStack < 0)
                ++plusTen
            ++tenStack
            now /= 2

        }
        while(now % 5 == 0){
            if(tenStack > 0)
                ++plusTen
            --tenStack
            now /= 5
        }
        facZero[i] = facZero[i - 1] + plusTen
    }
    val N = readLine().toInt()
    print("${facZero[N]}\n")
}