import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min
import kotlin.math.abs

var N = 0
var M = 0
var down = 0
var up = 0
var broken:String = ""

fun Down(n: Int){
    val str = n.toString()
    if(n < 0){
        down= 10000000
        return
    }

    for(i in 0..str.length - 1){
        if(broken.contains(str[i])){
            var next = str.substring(0, i + 1).toInt() - 1
            for(j in i..str.length - 2){
                next *= 10
                next += 9
            }
            down += n - next
            Down(next)
            return
        }
    }
    down += str.length

}
fun Up(n:Int){
    val str = n.toString()
    if(n > 10000000){
        up = 1000000
        return
    }
    for(i in 0..str.length - 1){
        if(broken.contains(str[i])){
            var next = str.substring(0, i + 1).toInt() + 1
            for(j in i..str.length - 2)
                next *= 10
            up += next - n
            Up(next)
            return
        }
    }
    up += str.length

}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    N = readLine().toInt()
    M = readLine().toInt()
    var ans = 999999
    if(M == 0){
        val fastans = min(N.toString().length, abs(N - 100))
        print("$fastans\n")
        return
    }

    broken = readLine().replace(" ", "")


    Up(N)
    Down(N)


    ans = min(down, up)
    ans = min(ans, abs(N - 100))

    print("$ans\n")

}