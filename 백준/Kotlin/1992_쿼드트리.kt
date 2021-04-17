import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var N = 0
var mmap = Array(65){IntArray(65){0} }
var failed = false
var check = BooleanArray(2){false}

fun United(xs:Int, ys:Int, size:Int){
    failed = false
    for(i in 0..1)
        check[i] = false
    loop@for(i in xs..xs + size - 1){
        for(j in ys..ys + size - 1){
            check[mmap[i][j]] = true
            if(check[0] && check[1] == true){
                failed = true
                break@loop
            }
        }
    }

    if(failed){
        val newSize = size / 2
        print("(")
        for(i in 0..1){
            for(j in 0..1){
                United(xs + (newSize * i), ys + (newSize * j), newSize)
            }
        }
        print(")")
    }else{
        for(i in 0..1){
            if(check[i])
                print(i)
        }
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    N = readLine().toInt()
    for(i in 1..N){
        val str = readLine()
        for(j in 1..N){
            mmap[i][j] = (str[j - 1] - '0').toInt()
        }
    }

    United(1, 1, N)
    print("\n")
}