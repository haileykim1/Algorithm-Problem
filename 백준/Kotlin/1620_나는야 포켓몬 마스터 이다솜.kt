import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var tok = StringTokenizer(readLine())
    val N = tok.nextToken().toInt()
    val M = tok.nextToken().toInt()
    var pokemon = ArrayList<String>()
    var poToNum = HashMap<String, Int>()

    pokemon.add("Missingno")
    for(i in 1..N){
        val creature = readLine()
        pokemon.add(creature)
        poToNum.put(creature, i)
    }
    for(i in 1..M){
        val command = readLine()
        val num = command.toIntOrNull()
        if(num == null)
            print("${poToNum[command]}\n")
        else
            print("${pokemon[num]}\n")
    }
}