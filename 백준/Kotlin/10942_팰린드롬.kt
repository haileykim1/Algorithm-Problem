import java.io.BufferedReader
import java.io.InputStreamReader

var N = 0
var M = 0
var arr = intArrayOf()
//가운데, 거리값
var palindrome = arrayOf<IntArray>()

fun isPalindrome(s: Int, e: Int): Int{
    if(palindrome[s][e] != -1){
        return palindrome[s][e]
    }
    if(e == s + 1){
        if(arr[s] == arr[e]){
            palindrome[s][e] = 1
        }else{
            palindrome[s][e] = 0
        }
        return palindrome[s][e]
    }
    var ret = 0
    if((isPalindrome(s + 1, e - 1)== 1) && (arr[s] == arr[e])){
        ret = 1
    }
    palindrome[s][e] = ret
    return ret
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val sb = StringBuilder()
    N = readLine().toInt()
    arr = IntArray(N + 1)
    palindrome = Array(N + 1){IntArray(N + 1){-1} }
    var input = readLine().split(" ")
    for(i in 1..N){
        arr[i] = input[i - 1].toInt()
        palindrome[i][i] = 1
    }
    M = readLine().toInt()


    repeat(M){
        input = readLine().split(" ")
        val S = input[0].toInt()
        val E = input[1].toInt()

        sb.append(isPalindrome(S, E))
        sb.append('\n')
    }

    print(sb.toString())
}