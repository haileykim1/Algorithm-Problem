import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val str = readLine()
    var s = Stack<Char>()
    var ans = ""

    for(i in 0..str.length - 1){
        if(str[i] >= 'A' && str[i] <= 'Z')
            ans += str[i]
        else if(str[i] == '*' || str[i] == '/'){
            while(s.isNotEmpty() && (s.peek() == '*' || s.peek() == '/')){
                ans += s.pop()
            }
            s.push(str[i])
        }
        else if(str[i] == '+' || str[i] == '-'){
            while(s.isNotEmpty() && s.peek() != '(')
                ans += s.pop()
            s.push(str[i])
        }else if(str[i] == '('){
            s.push(str[i])
        }
        else{
            while(s.isNotEmpty() && s.peek() != '(')
                ans += s.pop()
            s.pop()
        }
    }
    while(s.isNotEmpty()){
        ans += s.pop()
    }
    print("$ans\n")
}