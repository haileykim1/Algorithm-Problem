import java.util.*
/*
var arr = Array(1001, {IntArray(10){-1} })

fun DP(x:Int, y:Int):Int{
    if(arr[x][y] != -1)
        return arr[x][y]

    var sum:Int = 0
    for(i in 0..y)
        sum += DP(x - 1, i)
    arr[x][y] = sum % 10007
    return arr[x][y]
}

fun main() = with(Scanner(System.`in`)){
    val N = nextInt()
    for(i in 0..9)
        arr[1][i] = 1
    var sum:Int = 0
    for(i in 0..9)
        sum += DP(N, i)
    println(sum % 10007)
}*/