import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

//1264 모음의 개수

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    val sb = StringBuffer()

    while(true){
        val input = readLine()
        if(input == "#"){
            break
        }
        val regex = "[aeiouAEIOU]".toRegex()
        val matchResults = regex.findAll(input)
        sb.append(matchResults.count())
        sb.append("\n")
    }
    print(sb.toString())

}