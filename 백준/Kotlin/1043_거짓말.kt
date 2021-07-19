import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var tok = StringTokenizer(readLine())
    val N = tok.nextToken().toInt()
    val M = tok.nextToken().toInt()
    var ans = 0

    var fact = BooleanArray(N + 1){false}
    var party = Array(M + 1){BooleanArray(N + 1){false} }
    var queue = ArrayList<Int>()
    var pos = 0

    tok = StringTokenizer(readLine())
    val truthNum = tok.nextToken().toInt()
    if(truthNum == 0){
        print("$M\n")
        return
    }

    for(i in 1..truthNum){
        val temp = tok.nextToken().toInt()
        fact[temp] = true
        queue.add(temp)
    }

    for(i in 1..M){
        tok = StringTokenizer(readLine())
        for(j in 1..tok.nextToken().toInt()){
            party[i][tok.nextToken().toInt()] = true
        }
    }

    while(pos < queue.size){
        val now = queue[pos++]
        for(i in 1..M){
            if(party[i][now] == true){
                for(j in 1..N){
                    if(party[i][j] == true && fact[j] == false){
                        queue.add(j)
                        fact[j] = true
                    }
                }
            }
        }
    }

    for(i in 1..M){
        var lieOkay = true
        for(j in 1..N){
            if(party[i][j] == true && fact[j] == true){
                lieOkay = false
                break
            }
        }
        if(lieOkay)
            ++ans
    }

    print("$ans\n")
}