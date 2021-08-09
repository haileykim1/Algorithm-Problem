/*import java.io.BufferedReader
import java.io.EOFException
import java.io.InputStreamReader
import java.util.*

var arr = ArrayList<Int>()
var tree = arrayOf<IntArray>()

fun BuildTree(start: Int, end: Int){
    var leftstart = -1
    var leftend = -1
    var rightstart = -1
    var rightend = -1
    for(i in start + 1..end){

        if(arr[i] < arr[start]){
            if(leftstart == -1)
                leftstart = i

        }
        if(arr[i] > arr[start]){
            if((leftend == -1) && (leftstart != -1)){
                leftend = i - 1
            }
            if(rightstart == -1){
                rightstart = i
            }
        }
        if(i == end){
            if((leftstart != -1) && (leftend == -1))
                leftend = i

        }
    }
    if(leftstart != -1){
        tree[start][0] = leftstart
        BuildTree(leftstart, leftend)
    }
    if(rightstart!= -1){
        tree[start][1] = rightstart
        BuildTree(rightstart, end)
    }
}

fun PostOrder(x: Int){
    if(tree[x][0] != -1){
        PostOrder(tree[x][0])
    }
    if(tree[x][1] != -1){
        PostOrder(tree[x][1])
    }
    print("${arr[x]}\n")
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    while(true){
        val now = readLine()
        if(now == null || now.equals(""))
            break
        arr.add(now.toInt())
    }
    tree = Array(arr.size + 1){IntArray(2){-1} }
    BuildTree( 0, arr.size - 1)
    PostOrder(0)
}*/