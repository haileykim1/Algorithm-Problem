import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min
import kotlin.math.abs

var N = 0
var M = 0
var chicken = ArrayList<Pair<Int, Int>>()
var home = ArrayList<Pair<Int, Int>>()
var chickenCnt = 0
var chickenSelected = booleanArrayOf()
var chickenDist = 250000
var closest = intArrayOf()
var closestDist = intArrayOf()
var calCnt = 0

fun SelectChicken(x: Int, selected: Int){
    if( (chickenCnt - 1 - x) - (M - selected) < 0)
        return
    if((x == chickenCnt - 1 && selected == M) || selected == M){
        chickenDist = min(chickenDist, CalculateDist())
        return
    }
    else{
        for(i in x + 1..chickenCnt - 1){
            chickenSelected[i] = true
            SelectChicken(i, selected + 1)
            chickenSelected[i] = false
        }
    }

}

fun CalculateDist(): Int{
    ++calCnt
    var ret = 0
    for(j in 0..home.size - 1){
        var hx = home[j].first
        var hy = home[j].second
        if(chickenSelected[closest[j]]){
            ret += closestDist[j]
            continue
        }
        var mini = 100
        for(i in 0..chickenCnt - 1){
            if(chickenSelected[i]){
                var cx = chicken[i].first
                var cy = chicken[i].second
                mini = min(mini, abs(hx - cx) + abs(hy - cy))
            }
        }
        ret += mini
    }

    return ret
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var tok = StringTokenizer(readLine())
    N = tok.nextToken().toInt()
    M = tok.nextToken().toInt()

    for(i in 1..N){
        tok = StringTokenizer(readLine())
        for(j in 1..N){
            var input = tok.nextToken().toInt()
            if(input == 2){
                chicken.add(Pair(i, j))
            }else if(input == 1)
                home.add(Pair(i, j))
        }
    }
    chickenCnt = chicken.size
    chickenSelected = BooleanArray(chickenCnt){false}
    closest = IntArray(home.size)
    closestDist = IntArray(home.size)
    for(j in 0..home.size - 1){
        var mini = 100
        var minIdx = -1
        for(i in 0..chickenCnt - 1){
            var dist = abs(home[j].first - chicken[i].first) + abs(home[j].second - chicken[i].second)
            if(dist < mini){
                mini = dist
                minIdx = i
            }
        }
        closest[j] = minIdx
        closestDist[j] = mini
    }

    SelectChicken(-1, 0)
    print("$chickenDist\n")
}