import java.util.*

fun main() = with(Scanner(System.`in`)){
    val N = nextInt()
    for(i in 1..N){
        if(i == N){
            for(j in 1..2 * i - 1){
                print("*")
            }
        }
        else{
            for(j in 1..N + i - 1){
                if((j == N - i + 1) || (j == N + i - 1))
                    print("*")
                else
                    print(" ")
            }
        }
        println()
    }
}