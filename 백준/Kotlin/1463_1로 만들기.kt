/*import java.util.*
import kotlin.math.min


var dp = intArrayOf()

fun DP(X:Int):Int{
    if(dp[X] != -1)
        return dp[X]
    var a = 987654321
    if((X % 3) == 0)
       a = min(a, DP(X / 3) + 1)

    if((X % 2) == 0)
        a = min(a, DP(X / 2) + 1)

    a = min(a, DP(X - 1) + 1)
    dp[X] = a
    return a
}

fun main() = with(Scanner(System.`in`)){
    val N = nextInt()
    dp = IntArray(N + 1){
        if(it == 1) 0
        else -1
    }
    println(DP(N))

}*/