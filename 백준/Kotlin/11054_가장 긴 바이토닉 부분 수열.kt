import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max
/*
var N:Int = 0
var arr = IntArray(1001)
var dp = IntArray(1002)
var dp_rev = IntArray(1002)
var inc = IntArray(1001)
var inc_rev = IntArray(1002)
var len:Int = 0
var len_rev:Int = 0

fun binSearch(x:Int):Int{
    var left = 0
    var right = len
    var idx = (left + right) shr 1
    while(left < right){
        if(x <= inc[idx + 1])
            right = idx
        else
            left = idx + 1
        idx = (left + right) shr 1
    }
    return idx
}

fun binSearchRev(x:Int):Int{
    var small = N + 1
    var big = N + 1 - len_rev
    var idx = (small + big + 1) shr 1
    while(big < small){
        if(inc_rev[idx - 1] >= x)
            big = idx
        else
            small = idx - 1
        idx = (big + small + 1) shr 1
    }
    return idx
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    N = readLine().toInt()

    var tok = StringTokenizer(readLine())
    for(i in 1..N)
        arr[i] = tok.nextToken().toInt()

    for(i in 1..N){
        val a = binSearch(arr[i])
        dp[i] = a + 1
        inc[dp[i]] = arr[i]
        len = max(len, dp[i])
    }

    for(i in N downTo 1){
        val a = binSearchRev(arr[i])
        //println(a - 1)
        dp_rev[i] = N - a + 2
        inc_rev[a - 1] = arr[i]
        len_rev = max(len_rev, dp_rev[i])

    }

    var ans:Int = 0
    for(i in 1..N)
        ans = max(ans, dp[i] + dp_rev[i])
    println(ans - 1)
}*/