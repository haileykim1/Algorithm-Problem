import java.util.*
/*
var arr = Array<IntArray>(101, {IntArray(10){-1} })

fun DP(x:Int, y:Int):Int{
    if(arr[x][y] != -1)
        return arr[x][y]

    if(y == 0)
        arr[x][y] = DP(x - 1, 1)
    else if(y == 9)
        arr[x][y] = DP(x - 1, 8)
    else
        arr[x][y] = (DP(x - 1, y - 1) + DP(x - 1, y + 1)) % 1000000000
    return arr[x][y]
}

fun main() = with(Scanner(System.`in`)){
    val N = nextInt()
    arr[1][0] = 0
    for(i in 1..9)
        arr[1][i] = 1
    var sum:Int = 0
    for(i in 0..9)
        sum = (sum + DP(N, i)) % 1000000000
    println(sum)
}*/