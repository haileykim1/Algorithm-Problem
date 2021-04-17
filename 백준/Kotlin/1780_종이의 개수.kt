import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var N = 0
var mmap = Array(3000){IntArray(3000){0} }
//-1 0 1
var paperCnt = IntArray(3){0}
var check = BooleanArray(3){false}
var failed = false

fun United(xs: Int, ys: Int, size:Int){
    //println("$xs $ys $size")
    failed = false
    for(k in 0..2)
        check[k] = false
    loop@for(i in xs..xs + size - 1){
        for(j in ys..ys + size - 1){
            check[mmap[i][j] + 1] = true

            var trueCnt = 0;
            for(k in 0..2){
                if(check[k])
                    ++trueCnt
            }
            if(trueCnt > 1){
                failed = true
                break@loop
            }
        }
    }
    if(failed){
        val newSize = size / 3
        for(i in 0..2){
            for(j in 0..2){
                United(xs + (newSize * i), ys + (newSize * j), newSize)
            }
        }
    }else{
        for(i in 0..2){
            if(check[i]){
                paperCnt[i]++
            }
        }
    }

}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    N = readLine().toInt()

    for(i in 1..N){
        var tok = StringTokenizer(readLine())
        for(j in 1..N){
            mmap[i][j] = tok.nextToken().toInt()
        }
    }
    United(1, 1, N)

    paperCnt.forEach {
        print("$it\n")
    }
}
