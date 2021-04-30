class Solution {
    fun solution(s: String): IntArray {
        var answer = intArrayOf()
        var checked = BooleanArray(1000001){false}
        var tempArr = s.substring(1, s.length - 2).split("},").sortedBy{it.length}
        val len = tempArr.size
        var numArr = Array(len){IntArray(500)}
        for(i in 0..len - 1){
            val tempArr2 = tempArr[i].substring(1).split(",")
            for(j in 0..i){
                numArr[i][j] = tempArr2[j].toInt()
            }
        }
        answer = IntArray(len)
        for(i in 0..len - 1){
            for(j in 0..i){
                val now = numArr[i][j]
                if(!checked[now]){
                    answer[i] = now
                    checked[now] = true
                }
            }
        }
        return answer
    }
}