import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

var ans = -1
var N = ""
var arr = intArrayOf()
var K = 0
var len = 0
var map = HashMap<Pair<String, Int>, Boolean>()

fun swap(cnt: Int){

    if(cnt == K){
        var num = 0
        for(i in 0..len - 1){
            num *= 10
            num += arr[i]
        }
        ans = max(ans, num)
        return
    }
    var str = arr.joinToString()
    if(map.containsKey(Pair(str, cnt))){
        return
    }
    map.put(Pair(str, cnt), true)
    for(i in 0..len - 2){
        for(j in i + 1..len - 1){
            val a = arr[i]
            val b = arr[j]
            if((i == 0) && (b == 0)){
                continue
            }
            arr[i] = b
            arr[j] = a
            swap(cnt + 1)
            arr[i] = a
            arr[j] = b
        }
    }

}



fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val NK = readLine().split(" ")
    N = NK[0]
    K = NK[1].toInt()
    len = N.length
    arr = IntArray(len)

    for(i in 0..len - 1){
        arr[i] = Character.getNumericValue(N[i])
    }

    swap(0)
    print("$ans\n")
}