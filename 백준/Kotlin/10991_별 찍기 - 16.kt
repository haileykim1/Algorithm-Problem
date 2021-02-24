import java.util.*

fun main() = with(Scanner(System.`in`)){
    val N = nextInt()
    for(i in 1..N){
        for(j in 1..N - i)
            print(" ")
        for(j in 1..i)
            print("* ")
        println()
    }
}