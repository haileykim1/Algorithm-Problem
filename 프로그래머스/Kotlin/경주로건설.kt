import kotlin.math.min

class Solution {
    var N = 0
    var dirDP = Array(4){Array(25){IntArray(25){9999999}}}
    var nx = arrayOf(0, 1, 0, -1)
    var ny = arrayOf(1, 0, -1, 0)
    var queue = ArrayList<Pair<Int, Pair<Int, Int>>>()
    
    
    fun solution(board: Array<IntArray>): Int {
        var nCur = 0
        var eCur = 0
        var endQ = 2
        N = board.size
        
        dirDP[0][0][0] = 0
        dirDP[1][0][0] = 0        
        queue.add(Pair(0, Pair(0, 0)))
        queue.add(Pair(1, Pair(0, 0)))
        
        while(eCur < endQ){
            eCur = endQ
            while(nCur < eCur){
                val dir = queue[nCur].first
                val x = queue[nCur].second.first
                val y = queue[nCur].second.second
                
                
                for(i in 0..3){
                    val nnx = x + nx[i]
                    val nny = y + ny[i]
                    if((nnx < 0) || (nnx >= N) || (nny < 0) || (nny >= N))
                        continue
                    //0, 2 또는 2, 0
                    if(((i + dir) == 2) && (i != 1))
                        continue
                    //1, 3 또는 3, 1
                    if(((i + dir) == 4) && (i != 2))
                        continue
                    if(board[nnx][nny] == 1)
                        continue
                    
                    val now = dirDP[dir][x][y]
                    val next = dirDP[i][nnx][nny]
                    var cost = 0
                    if(i == dir)
                        cost = 100
                    else
                        cost = 600
                    
                    if((now + cost) < next){
                        dirDP[i][nnx][nny] = now + cost
                        queue.add(Pair(i, Pair(nnx, nny)))
                        ++endQ
                    }
                }
                ++nCur
                
            }
        }
        var answer = min(dirDP[0][N - 1][N - 1], dirDP[1][N - 1][N - 1])
        return answer
    }
}