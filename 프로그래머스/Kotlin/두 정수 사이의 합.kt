class Solution {
    fun solution(a: Int, b: Int): Long {
        var answer: Long = 0
        if(a == b)
            answer += a
        else if(a > b){
            for(i in b..a)
                answer += i
        }else{
            for(i in a..b)
                answer += i
        }
        return answer
    }
}