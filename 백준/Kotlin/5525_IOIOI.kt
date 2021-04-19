import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val N = readLine().toInt()
    val lenS = readLine().toInt()
    val S = readLine()

    var ans = 0
    var counting = false
    var isI = false
    var IOICnt = 0

    for(i in 0..lenS - 1){
        //IOI중인경우
        if(counting){
            if(!isI && (S[i] == 'I')){
                isI = true
                if(++IOICnt >= N)
                    ++ans
                continue
            }else if(isI && (S[i] == 'O')){
                isI = false
                continue
            }else{
                IOICnt = 0
                counting = false
                isI = false
            }
        }
        //IOI 빌드단계
        if(!counting && (S[i] == 'I')){
            counting = true
            isI = true
        }else{
            counting = false
            isI = false
        }
    }
    //IOIOI
    print("$ans\n")
}