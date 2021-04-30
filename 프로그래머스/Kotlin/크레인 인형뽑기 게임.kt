import java.util.*

class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        val N = board.size
        var cur = IntArray(N)
        var bucket = Stack<Int>()
        for(i in 0..N - 1){
            for(j in 0..N - 1){
                if(board[j][i]!= 0){
                    cur[i] = j
                    break
                }
            }
        }
        moves.forEach{
            val now = it
            if(cur[it - 1] < N){
                val pick = board[cur[it - 1]++][it - 1]
                if(bucket.isNotEmpty() && (bucket.peek() == pick)){
                    bucket.pop()
                    answer += 2
                }else{
                    bucket.push(pick)
                }
            }
        }
        return answer
    }
}