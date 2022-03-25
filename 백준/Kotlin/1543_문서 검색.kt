import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    val document = readLine()
    val word = readLine()

    val regex = word.toRegex()
    val results = regex.findAll(document)

    println("${results.count()}\n")

}