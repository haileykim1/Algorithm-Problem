import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    while(true){
        val str = readLine()
        if(str == "0")
            break
        val revStr = str.reversed()
        if(str.equals(revStr))
            print("yes\n")
        else
            print("no\n")
    }

}