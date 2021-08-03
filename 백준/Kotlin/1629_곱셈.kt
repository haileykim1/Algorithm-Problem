import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.pow

var A = 0
var B = 0
var C = 0

fun PowerFunc(exp: Int): Int{
    if(exp == 0){
        return 1
    }else if(exp == 1){
        return A % C
    }else{
        var temp:Long = 1.toLong()
        if(exp % 2 == 0){
            var a = PowerFunc(exp / 2)
            temp = a.toLong() * a % C
        }else{
            var a = PowerFunc((exp - 1) / 2)
            temp = a.toLong() * a % C * (A % C) % C
        }
        return temp.toInt()
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val tok = StringTokenizer(readLine())
    A = tok.nextToken().toInt()
    B = tok.nextToken().toInt()
    C = tok.nextToken().toInt()

    print("${PowerFunc(B)}\n")
}