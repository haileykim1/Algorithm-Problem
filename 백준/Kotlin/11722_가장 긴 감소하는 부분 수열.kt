import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max
/*
var arr = IntArray(1001)
var dp = IntArray(1001)
var num = IntArray(1001){0}
var ans:Int = 0

fun binSearch(x:Int):Int{
    var left:Int = 0
    var right:Int = ans
    var idx:Int = (left + right) shr 1
    while(left < right){
        if(x >= num[idx + 1]){
            right = idx
        }else{
            left = idx + 1
        }
        idx = (left + right) shr 1
    }
    return idx
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val N = readLine().toInt()
    var tok = StringTokenizer(readLine())
    for(i in 1..N)
        arr[i] = tok.nextToken().toInt()
    dp[0] = 0
    num[0] = 1001
    for(i in 1..N){
        val a = binSearch(arr[i])
        dp[i] = a + 1
        num[dp[i]] = arr[i]
        ans = max(ans, dp[i])
        /*for(i in 0..ans)
            print("${num[i]} ")
        println()*/
    }
    println(ans)
}*/