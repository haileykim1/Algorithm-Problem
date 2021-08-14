import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var str = Array<String>(2){""}
    str[0] = readLine()
    str[1] = readLine()
    var arr = Array(str[0].length + 1){IntArray(str[1].length + 1){0} }

    for(i in 0..str[0].length - 1){
        for(j in 0..str[1].length - 1){
            if(str[0][i] == str[1][j]){
                arr[i + 1][j + 1] = arr[i][j] + 1
            }else{
                arr[i + 1][j + 1] = max(arr[i][j + 1], arr[i + 1][j])
            }
        }
    }
    print("${arr[str[0].length][str[1].length]}\n")
}