class Solution {
    var visited = BooleanArray(200){false}
    var num = 0
    var com = arrayOf<IntArray>()
    
    fun Connecting(x:Int){
        visited[x] = true
        for(i in 0..num - 1){
            if((com[x][i] == 1) && !visited[i])
                Connecting(i)
        }
    }
    
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        num = n
        com = computers
        for(i in 0..n - 1){
            if(!visited[i]){
                Connecting(i)
                ++answer
            }
        }
        return answer
    }
}