import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var N = 0
var arr = arrayOf<String>()
var firstAns = 0
var secondAns = 0
var sector = arrayOf<IntArray>()
var dx = arrayOf(-1, 0, 0, 1)
var dy = arrayOf(0, -1, 1, 0)

fun Area(x: Int, y: Int){

    for(i in 0..3){
        val nx = x + dx[i]
        val ny = y + dy[i]
        if((nx < 0) || (nx >= N) || (ny < 0) || (ny >= N))
            continue
        if(sector[nx][ny] == -1 && (arr[nx][ny] == arr[x][y])){
            sector[nx][ny] = sector[x][y]
            Area(nx, ny)
        }
    }
}

fun rgAndbArea(x: Int, y: Int){
    for(i in 0..3){
        val nx = x + dx[i]
        val ny = y + dy[i]
        if((nx < 0) || (nx >= N) || (ny < 0) || (ny >= N))
            continue
        if(sector[nx][ny] == -1){
            if(((arr[x][y] == 'B') && (arr[nx][ny] == 'B')) || ((arr[x][y] != 'B') && (arr[nx][ny] != 'B'))){
                sector[nx][ny] = sector[x][y]
                rgAndbArea(nx, ny)
            }
        }
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    N = readLine().toInt()
    arr = Array(N + 1){""}
    sector = Array(N){IntArray(N){-1} }

    for(i in 0..N - 1)
        arr[i] = readLine()

    for(i in 0..N - 1){
        for(j in 0..N - 1){
            if(sector[i][j] == -1){
                sector[i][j] = ++firstAns
                Area(i, j)
            }
        }
    }
    Area(0, 0)
    for(i in 0..N - 1){
        sector[i].fill(-1)
    }
    for(i in 0..N - 1){
        for(j in 0..N - 1){
            if(sector[i][j] == -1){
                sector[i][j] = ++secondAns
                rgAndbArea(i, j)
            }
        }
    }

    print("$firstAns $secondAns\n")
}