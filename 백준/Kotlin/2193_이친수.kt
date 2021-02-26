import java.util.*
/*
var arr = Array(91, {LongArray(2){-1L}})

fun DP(x:Int, y:Int):Long{
    if(arr[x][y] != -1L)
        return arr[x][y]
    if(y == 0)
        arr[x][y] = DP(x - 1, 0) + DP(x - 1, 1)
    else
        arr[x][y] = DP(x - 1, 0)
    return arr[x][y]
}

fun main() = with(Scanner(System.`in`)){
    val N = nextInt()
    arr[1][0] = 0L
    arr[1][1] = 1L
    println(DP(N, 0) + DP(N, 1))
}*/