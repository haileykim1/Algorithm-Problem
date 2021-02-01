import java.util.*

var N = 0
var M = 0
var maxi = 0
var list = mutableListOf<Int>()

fun main() = with(Scanner(System.`in`)){

    N = nextInt()
    M = nextInt()

    for (i in 1..N)
        list.add(nextInt())
    list.sort()

    for(i in 0..N - 3){
        for(j in i + 1..N - 2){
            for(k in j + 1..N - 1){
                var a = list[i] + list[j] + list[k]
                if(a > M )
                    break
                if(a > maxi)
                    maxi = a

            }
        }
    }
    println(maxi)
}