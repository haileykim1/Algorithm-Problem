import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Math.sqrt
import java.util.*
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var n = readLine().toInt()
    var ans = 0
    val arr = IntArray(n + 1){-1}

    for(i in 1..sqrt(n.toDouble()).toInt()){
        arr[i * i] = 1
    }

    var temp = 0
    for(i in 1..n){
        if(arr[i] != 1){
            var mini = 9
            for(j in 1..sqrt(i.toDouble()).toInt()){
                mini = min(mini, 1 + arr[i - j * j])
            }
            arr[i] = mini
        }
    }


    print("${arr[n]}\n")
}