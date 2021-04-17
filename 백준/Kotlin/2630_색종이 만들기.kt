import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
var cnt = IntArray(2){0}
var mmap = Array(129){IntArray(129){0} }
var check = BooleanArray(2){false}
var failed = false

fun United(xs:Int, ys:Int, size:Int){
    failed = false
    for(i in 0..1)
        check[i] = false
    loop@for(i in xs..xs + size - 1){
        for(j in ys..ys + size - 1){
            check[mmap[i][j]] = true
            if(check[0] && check[1]){
                failed = true
                break@loop
            }
        }
    }
    if(failed){
        val newSize = size / 2
        for(i in 0..1){
            for(j in 0..1){
                United(xs + (newSize * i), ys + (newSize * j), newSize)
            }
        }
    }else{
        for(i in 0..1){
            if(check[i])
                ++cnt[i]
        }
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val N = readLine().toInt()
    for(i in 1..N){
        val tok = StringTokenizer(readLine())
        for(j in 1..N){
            mmap[i][j] = tok.nextToken().toInt()
        }
    }
    United(1, 1, N)

    print("${cnt[0]}\n")
    print("${cnt[1]}\n")

}