import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var tree = arrayOf<CharArray>()
var indexToNode = charArrayOf()
var nodeToIndex = HashMap<Char, Int>()
var N = 0

fun PreOrder(x:Int){
    print(indexToNode[x])
    if(tree[x][0] != '.')
        PreOrder(nodeToIndex.get(tree[x][0])!!)

    if(tree[x][1] != '.')
        PreOrder(nodeToIndex.get(tree[x][1])!!)
}

fun InOrder(x: Int){
    if(tree[x][0] != '.')
        InOrder(nodeToIndex.get(tree[x][0])!!)

    print(indexToNode[x])

    if(tree[x][1] != '.')
        InOrder(nodeToIndex.get(tree[x][1])!!)
}

fun PostOrder(x: Int){
    if(tree[x][0] != '.')

        PostOrder(nodeToIndex.get(tree[x][0])!!)

    if(tree[x][1] != '.')
        PostOrder(nodeToIndex.get(tree[x][1])!!)

    print(indexToNode[x])
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    N = readLine().toInt()
    tree = Array(N + 1){CharArray(2)}
    indexToNode = CharArray(N + 1)
    for(i in 0..N - 1){
        val tok = StringTokenizer(readLine())
        indexToNode[i] = tok.nextToken()[0]
        nodeToIndex.put(indexToNode[i], i)
        tree[i][0] = tok.nextToken()[0]
        tree[i][1] = tok.nextToken()[0]
    }

    PreOrder(0)
    print("\n")
    InOrder(0)
    print("\n")
    PostOrder(0)
}