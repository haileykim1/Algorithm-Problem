import java.util.*
/*
var arr = mutableListOf<Int>()
var maxi:Int = 0
var N = 0

fun energySaving(nowEnergy:Int){
    if(arr.size <= 2){
        if(nowEnergy > maxi)
            maxi = nowEnergy
        return
    }
    for(i in 1..arr.size - 2){
        var value = arr[i]
        var mul =  arr[i - 1] * arr[i + 1]
        arr.removeAt(i)
        energySaving(nowEnergy + mul)
        arr.add(i, value)
    }
}

fun main() = with(Scanner(System.`in`)){
    N = nextInt()

    for (i in 0..N - 1){
    arr.add(nextInt())
    }
    energySaving(0)
    print(maxi)
}*/